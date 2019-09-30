package com.example.application.controllers;

import com.example.weatherapi.WeatherApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ForecastsControllerIntegrationTest extends MockMvcIntegrationTest {

    private WeatherApi weatherApi;

    @Autowired
    ForecastsControllerIntegrationTest(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Test
    void getIndex() {
        Assertions.assertTrue(
                verifyCollectionSize(weatherApi.findAll().size())
        );
    }

    @Test
    void getPlacesWithTemperature() {
        Assertions.assertTrue(
                verifyCollectionSize(weatherApi.findAll(WeatherApi::filterPlacesByTemperatureType).size())
        );
    }

    @Test
    void getWinds() {
        Assertions.assertTrue(
                verifyCollectionSize(weatherApi.findAll(WeatherApi::filterPlacesByWindType).size())
        );
    }

    private boolean verifyCollectionSize(int size) {
        return size >= 1;
    }
}