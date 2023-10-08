package ie.nci.journey.api;

import ie.nci.journey.api.dto.AiApiDto;
import ie.nci.journey.controller.dto.response.AiResDto;
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
    @Resource
    private RestTemplate restTemplate;

    public String getAiToken() {
        ResponseEntity<String> response = restTemplate.getForEntity("https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id=x5ElkR5OBBSRZbyDMm0dIYvL&client_secret=F2aAk53KPLTWQjY7T2G3C2HEnKb05Yuq", String.class);
        return response.getBody();
    }

    public AiResDto getAiAnswer(String question) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer YourAccessToken");
        headers.set("Content-Type", "application/json");
        HttpEntity<String> requestEntity = new HttpEntity<>("{\"messages\":[{\"role\":\"user\",\"content\":\"" + question + "\"}]}", headers);

        ResponseEntity<AiApiDto> response = restTemplate.postForEntity(
                "https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/eb-instant?access_token=24.dc699c850f5cfbd93a00ee40c4515ffa.2592000.1699055845.282335-40499958",
                requestEntity,
                AiApiDto.class
        );
        AiApiDto aiApiDto = response.getBody();
        assert aiApiDto != null;

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return new AiResDto(aiApiDto.getResult(), dateFormat.format(aiApiDto.getCreated()));
    }
}
