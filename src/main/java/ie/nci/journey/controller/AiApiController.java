package ie.nci.journey.controller;

import ie.nci.journey.api.AiApi;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AiApiController
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-08
 */
@RestController
public class AiApiController {
    @Resource
    private AiApi aiApi;

    @PostMapping("/ai")
    public String getAiAnswer(String question) {
        return aiApi.getAiAnswer(question);
    }
}
