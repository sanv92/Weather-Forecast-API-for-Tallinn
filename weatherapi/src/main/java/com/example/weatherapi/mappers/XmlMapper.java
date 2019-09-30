package com.example.weatherapi.mappers;

import com.example.weatherapi.model.forecastxml.ForecastGroupXml;

import java.io.IOException;

public class XmlMapper implements Mapper {

    @Override
    public ForecastGroupXml map(String content) throws IOException {
        return new com.fasterxml.jackson.dataformat.xml.XmlMapper()
                .readValue(content, ForecastGroupXml.class);
    }
}
