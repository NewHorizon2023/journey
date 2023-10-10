package ie.nci.journey.controller;

import ie.nci.journey.api.AiApi;
import ie.nci.journey.api.AirbnbApi;
import ie.nci.journey.api.WeatherApi;
import ie.nci.journey.api.dto.AirbnbDto;
import ie.nci.journey.api.dto.WeatherDto;
import ie.nci.journey.controller.dto.Response;
import ie.nci.journey.controller.dto.request.AiReqDto;
import ie.nci.journey.controller.dto.request.AirbnbReqDto;
import ie.nci.journey.controller.dto.response.AiResDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

/**
 * AiApiController
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-08
 */
@RestController
@RequestMapping("/api")
public class ApiController {
    @Resource
    private AiApi aiApi;
    @Resource
    private WeatherApi weatherApi;
    @Resource
    private AirbnbApi airbnbApi;

    @PostMapping("/ai")
    public Response<AiResDto> getAiAnswer(@RequestBody AiReqDto aiReqDto) {
        return Response.ok(aiApi.getAiAnswer(aiReqDto));
    }

    @GetMapping("/weather")
    public Response<WeatherDto> getWeatherInfo(@RequestParam String location) {
        return Response.ok(weatherApi.getWeatherInfo(location));
    }

    @GetMapping("/airbnb")
    public Response<AirbnbDto> getAirbnbInfo(AirbnbReqDto airbnbReqDto) {
        return Response.ok(airbnbApi.getAirbnbInfo(airbnbReqDto));
    }

}
