package com.example.application.services;

import com.example.weatherapi.WeatherApi;
import com.example.weatherapi.model.PhenomenonType;
import com.example.weatherapi.model.PlaceType;
import com.example.weatherapi.model.TimeOfDayType;
import com.example.weatherapi.model.WindType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherTypesService {

    private final WeatherApi weatherApi;

    @Autowired
    public WeatherTypesService(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    public List<PlaceType> getPlaceTypes() {
        return weatherApi.findPlaceTypes();
    }

    public List<PhenomenonType> getPhenomenonTypes() {
        return weatherApi.findPhenomenonTypes();
    }

    public List<TimeOfDayType> getTimeOfDayTypes() {
        return weatherApi.findTimeOfDayTypes();
    }

    public List<WindType> getWindTypes() {
        return weatherApi.findWindTypes();
    }
}
