package com.example.weatherapi.converters;

import com.example.weatherapi.model.PhenomenonType;
import com.example.weatherapi.model.PlaceType;
import com.example.weatherapi.model.forecast.Place;
import com.example.weatherapi.model.forecast.Prediction;
import com.example.weatherapi.model.forecast.Temperature;
import com.example.weatherapi.model.forecastxml.PlaceXml;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;
import java.util.UUID;

public class TemperatureXmlToTemperature implements Converter<PlaceXml, Place> {

    @Override
    public Place convert(PlaceXml placeXml) {
        Place place = new Place();
        place.setUuid(UUID.randomUUID());
        place.setPlaceType(getPlaceType(placeXml.getName()));

        Prediction prediction = new Prediction();
        prediction.setTemperature(getTemperature(placeXml));
        place.setPrediction(prediction);

        return place;
    }

    private PlaceType getPlaceType(String name) {
        for (PlaceType value : PlaceType.values()) {
            if (value.getName().equalsIgnoreCase(name)) {
                return value;
            }
        }

        return null;
    }

    private Temperature getTemperature(PlaceXml placeXml) {
        Temperature temperature = new Temperature();

        if (Optional.ofNullable(placeXml.getTempMin()).isPresent()) {
            temperature.setMin(placeXml.getTempMin());
        }
        if (Optional.ofNullable(placeXml.getTempMax()).isPresent()) {
            temperature.setMax(placeXml.getTempMax());
        }

        temperature.setPhenomenon(getPhenomenonType(placeXml.getPhenomenon()));

        return temperature;
    }

    private PhenomenonType getPhenomenonType(String name) {
        for (PhenomenonType value : PhenomenonType.values()) {
            if (value.getName().equalsIgnoreCase(name)) {
                return value;
            }
        }

        return null;
    }
}
