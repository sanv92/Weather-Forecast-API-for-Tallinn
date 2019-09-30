package com.example.weatherapi.mappers;

import com.example.weatherapi.model.forecastxml.ForecastGroupXml;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonMapper implements Mapper {

    @Override
    public ForecastGroupXml map(String content) throws IOException {
        return new ObjectMapper()
                .readValue(content, ForecastGroupXml.class);
    }
}
