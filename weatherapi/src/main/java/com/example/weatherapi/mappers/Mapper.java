package com.example.weatherapi.mappers;

import com.example.weatherapi.model.forecastxml.ForecastGroupXml;

import java.io.IOException;

public interface Mapper {
    ForecastGroupXml map(String data) throws IOException;
}
