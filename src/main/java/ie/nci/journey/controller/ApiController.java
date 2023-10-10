package ie.nci.journey.controller;

import ie.nci.journey.api.AiApi;
import ie.nci.journey.api.AirbnbApi;
import ie.nci.journey.api.WeatherApi;
import ie.nci.journey.api.dto.AirbnbDto;
import ie.nci.journey.api.dto.WeatherDto;
import ie.nci.journey.controller.dto.Response;
import ie.nci.journey.controller.dto.request.AirbnbReqDto;
import ie.nci.journey.controller.dto.response.AiResDto;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/ai")
    public Response<AiResDto> getAiAnswer(@RequestParam String question) {
        return Response.ok(aiApi.getAiAnswer(question));
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
