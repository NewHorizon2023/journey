package ie.nci.journey.api;

import ie.nci.journey.api.dto.AirbnbDto;
import ie.nci.journey.controller.dto.request.AirbnbReqDto;
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
 * Airbnb
 *
 * @Author: Xiangnan Liu
 * @CreateTime: 2023-10-10
 */
@Component
public class AirbnbApi {
    @Value("${api.airbnb.url}")
    private String url;
    @Value("${api.airbnb.key}")
    private String key;
    @Value("${api.airbnb.host}")
    private String host;

    @Resource
    private RestTemplate restTemplate;

    public AirbnbDto getAirbnbInfo(AirbnbReqDto airbnbReqDto) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", key);
        headers.set("X-RapidAPI-Host", host);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        UriComponentsBuilder builder = fromUriString(url)
                .queryParam("location", airbnbReqDto.getLocation())
                .queryParam("checkin", airbnbReqDto.getCheckin())
                .queryParam("checkout", airbnbReqDto.getCheckout())
                .queryParam("adults", airbnbReqDto.getAdults())
                .queryParam("children", airbnbReqDto.getChildren())
                .queryParam("infants", airbnbReqDto.getInfants())
                .queryParam("pets", airbnbReqDto.getPets())
                .queryParam("page", airbnbReqDto.getPage())
                .queryParam("currency", airbnbReqDto.getCurrency());

        ResponseEntity<AirbnbDto> response = restTemplate.exchange(builder.toUriString(), GET, entity, AirbnbDto.class);

        return response.getBody();
    }
}
