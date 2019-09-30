package com.example.application.controllers;

import com.example.weatherapi.WeatherApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class ForecastsTypesControllerIntegrationTest extends MockMvcIntegrationTest {

    private WeatherApi weatherApi;

    @Autowired
    ForecastsTypesControllerIntegrationTest(WeatherApi weatherApi) {
        this.weatherApi = weatherApi;
    }

    @Test
    void getPlaceTypes() {
        Assertions.assertTrue(
                verifyCollectionSize(weatherApi.findPlaceTypes().size())
        );
    }

    @Test
    void getPhenomenonTypes() {
        Assertions.assertTrue(
                verifyCollectionSize(weatherApi.findPhenomenonTypes().size())
        );
    }

    @Test
    void getTimeOfDayTypes() {
        Assertions.assertTrue(
                verifyCollectionSize(weatherApi.findTimeOfDayTypes().size())
        );
    }

    @Test
    void getWindTypes() {
        Assertions.assertTrue(
                verifyCollectionSize(weatherApi.findWindTypes().size())
        );
    }

    private boolean verifyCollectionSize(int size) {
        return size >= 1;
    }
}