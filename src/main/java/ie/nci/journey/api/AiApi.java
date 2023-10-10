package ie.nci.journey.api;

import ie.nci.journey.api.dto.AiAccessTokenDto;
import ie.nci.journey.api.dto.AiDto;
import ie.nci.journey.controller.dto.response.AiResDto;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.text.SimpleDateFormat;

import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

/**
 * ThirdPartApi
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-08
 */
@Component
public class AiApi {
    private String accessToken;
    @Resource
    private RestTemplate restTemplate;

    @Value("${api.ai.answer.url}")
    private String answerUrl;

    @Value("${api.ai.getAccessToken.url}")
    private String tokenUrl;

    @Value("${api.ai.getAccessToken.grantType}")
    private String grantType;

    @Value("${api.ai.getAccessToken.clientId}")
    private String clientId;

    @Value("${api.ai.getAccessToken.clientSecret}")
    private String clientSecret;

    @PostConstruct
    public void init() {
        // Get access token for AI request
        getAiAccessToken();
    }

    public void getAiAccessToken() {
        UriComponentsBuilder builder = fromUriString(tokenUrl)
                .queryParam("grant_type", grantType)
                .queryParam("client_id", clientId)
                .queryParam("client_secret", clientSecret);

        // Request for access token
        ResponseEntity<AiAccessTokenDto> response = restTemplate.getForEntity(builder.toUriString(), AiAccessTokenDto.class);
        AiAccessTokenDto aiAccessTokenDto = response.getBody();
        accessToken = aiAccessTokenDto.getAccessToken();
    }

    public AiResDto getAiAnswer(String question) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>("{\"messages\":[{\"role\":\"user\",\"content\":\"" + question + "\"}]}", headers);

        // Get answer from AI
        ResponseEntity<AiDto> response = restTemplate.postForEntity(answerUrl + accessToken, requestEntity, AiDto.class);
        AiDto aiDto = response.getBody();

        // If access token expired, request again
        if (aiDto == null || aiDto.getResult() == null) {
            getAiAccessToken();
            response = restTemplate.postForEntity(answerUrl + accessToken, requestEntity, AiDto.class);
            aiDto = response.getBody();
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return new AiResDto(aiDto.getResult(), dateFormat.format(aiDto.getCreated()));
    }
}
