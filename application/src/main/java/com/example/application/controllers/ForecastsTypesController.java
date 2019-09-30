package com.example.application.controllers;

import com.example.application.services.WeatherTypesService;
import com.example.weatherapi.model.PhenomenonType;
import com.example.weatherapi.model.PlaceType;
import com.example.weatherapi.model.TimeOfDayType;
import com.example.weatherapi.model.WindType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/forecasts")
@RestController
public class ForecastsTypesController {

    private final WeatherTypesService weatherTypesService;

    @Autowired
    public ForecastsTypesController(WeatherTypesService weatherTypesService) {
        this.weatherTypesService = weatherTypesService;
    }

    @GetMapping("/place-types")
    public List<PlaceType> getPlaceTypes() {
        return weatherTypesService.getPlaceTypes();
    }

    @GetMapping("/phenomenon-types")
    public List<PhenomenonType> getPhenomenonTypes() {
        return weatherTypesService.getPhenomenonTypes();
    }

    @GetMapping("/time-of-day-types")
    public List<TimeOfDayType> getTimeOfDayTypes() {
        return weatherTypesService.getTimeOfDayTypes();
    }

    @GetMapping("/wind-types")
    public List<WindType> getWindTypes() {
        return weatherTypesService.getWindTypes();
    }
}
