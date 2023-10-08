package ie.nci.journey.controller;

import ie.nci.journey.api.AiApi;
import ie.nci.journey.controller.param.Response;
import ie.nci.journey.controller.param.request.AiReqParam;
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
    public Response<String> getAiAnswer(@RequestBody AiReqParam request) {
        return Response.ok(aiApi.getAiAnswer(request.getQuestion()));
    }
}
