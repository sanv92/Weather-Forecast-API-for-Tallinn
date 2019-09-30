package com.example.application.controllers;

import com.example.application.services.WeatherService;
import com.example.weatherapi.model.forecast.Forecast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/forecasts")
@RestController
public class ForecastsController {

    private final WeatherService weatherService;

    @Autowired
    public ForecastsController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/places")
    public List<Forecast> index() {
        return weatherService.getAllPlaces();
    }

    @GetMapping("/places/temperature")
    public List<Forecast> getPlacesWithTemperature() {
        return weatherService.getFilteredPlacesByTemperature();
    }

    @GetMapping("/places/winds")
    public List<Forecast> getWinds() {
        return weatherService.getFilteredPlacesByWinds();
    }
}
