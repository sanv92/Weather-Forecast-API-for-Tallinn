package com.example.application.services;

import com.example.weatherapi.WeatherApi;
import com.example.weatherapi.model.forecast.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class WeatherService {

    private final WeatherApi weatherApi;

    @Autowired
    public WeatherService(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public List<Forecast> getAllPlaces() {
        return weatherApi.findAll();
    }

    public List<Forecast> getFilteredPlacesByTemperature() {
        return weatherApi.findAll(
                WeatherApi::filterPlacesByTemperatureType
        );
    }

    public List<Forecast> getFilteredPlacesByWinds() {
        return weatherApi.findAll(
                WeatherApi::filterPlacesByWindType
        );
    }
}
