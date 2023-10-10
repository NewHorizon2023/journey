package ie.nci.journey.api;

import ie.nci.journey.api.dto.WeatherDto;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

/**
 * WeatherApi
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-10
 */
@Component
public class WeatherApi {
    @Value("${api.weather.url}")
    private String url;
    @Value("${api.weather.key}")
    private String key;
    @Value("${api.weather.host}")
    private String host;

    @Resource
    private RestTemplate restTemplate;

    public WeatherDto getWeatherInfo(String location) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", key);
        headers.set("X-RapidAPI-Host", host);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = fromUriString(url).queryParam("q", location);
        ResponseEntity<WeatherDto> response = restTemplate.exchange(builder.toUriString(), GET, entity, WeatherDto.class);

        return response.getBody();
    }

}
