package ie.nci.journey.controller;

import ie.nci.journey.api.AiApi;
import ie.nci.journey.controller.dto.Response;
import ie.nci.journey.controller.dto.request.AiReqDto;
import ie.nci.journey.controller.dto.response.AiResDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public Response<AiResDto> getAiAnswer(@RequestBody AiReqDto request) {
        return Response.ok(aiApi.getAiAnswer(request.getQuestion()));
    }
}
