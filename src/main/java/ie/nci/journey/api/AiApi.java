package ie.nci.journey.api;

import ie.nci.journey.api.dto.AccessTokenDto;
import ie.nci.journey.api.dto.AiApiDto;
import ie.nci.journey.controller.dto.response.AiResDto;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;

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

    @PostConstruct
    public void init() {
        getAiAccessToken();
    }

    public void getAiAccessToken() {
        ResponseEntity<AccessTokenDto> response = restTemplate.getForEntity("https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=x5ElkR5OBBSRZbyDMm0dIYvL&client_secret=F2aAk53KPLTWQjY7T2G3C2HEnKb05Yuq", AccessTokenDto.class);
        AccessTokenDto accessTokenDto = response.getBody();
        assert accessTokenDto != null;
        accessToken = accessTokenDto.getAccessToken();
    }

    public AiResDto getAiAnswer(String question) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>("{\"messages\":[{\"role\":\"user\",\"content\":\"" + question + "\"}]}", headers);

        ResponseEntity<AiApiDto> response = restTemplate.postForEntity(
                "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/eb-instant?access_token=" + accessToken,
                requestEntity,
                AiApiDto.class
        );

        AiApiDto aiApiDto = response.getBody();
        // If access token expired, request again
        if (aiApiDto == null) {
            getAiAccessToken();
            response = restTemplate.postForEntity(
                    "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/eb-instant?access_token=" + accessToken,
                    requestEntity,
                    AiApiDto.class
            );
            aiApiDto = response.getBody();
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        assert aiApiDto != null; // assert 应该怎么用？

        return new AiResDto(aiApiDto.getResult(), dateFormat.format(aiApiDto.getCreated()));
    }
}
