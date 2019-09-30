package com.example.weatherapi;

import com.example.weatherapi.mappers.MapperFactory;
import com.example.weatherapi.model.forecastxml.ForecastGroupXml;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

abstract class BaseApi {

    private WeatherProperties properties;

    private RestTemplate restTemplate;

    public BaseApi() {}

    public BaseApi(WeatherProperties properties, RestTemplate restTemplate) {
        this.properties = properties;
        this.restTemplate = restTemplate;
    }

    protected Optional<ForecastGroupXml> doRequest(String url) {
        String uriBuilder = buildRequest()
                .path(url).toUriString();

        ResponseEntity<String> response = restTemplate.getForEntity(
                uriBuilder,
                String.class
        );

        if (!Optional.ofNullable(response.getBody()).isPresent()) {
            return Optional.empty();
        }

        return Optional.of(
                new MapperFactory.Builder()
                        .withContent(response.getBody())
                        .map(MediaType.APPLICATION_XML)
        );
    }

    private UriComponentsBuilder buildRequest() {
        return UriComponentsBuilder
                .fromUriString(properties.getApiUrl())
                .queryParam("lang", properties.getLocale());
    }
}
