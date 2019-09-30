package com.example.weatherapi.converters;

import com.example.weatherapi.model.PlaceType;
import com.example.weatherapi.model.WindType;
import com.example.weatherapi.model.forecast.Place;
import com.example.weatherapi.model.forecast.Prediction;
import com.example.weatherapi.model.forecast.Wind;
import com.example.weatherapi.model.forecastxml.WindXml;
import org.springframework.core.convert.converter.Converter;

import java.util.Optional;
import java.util.UUID;

public class WindXmlToPlace implements Converter<WindXml, Place> {

    @Override
    public Place convert(WindXml windXml) {
        Place place = new Place();
        place.setUuid(UUID.randomUUID());
        place.setPlaceType(getPlaceType(windXml.getName()));

        Prediction prediction = new Prediction();
        prediction.setWind(getWind(windXml));
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

    private Wind getWind(WindXml windXml) {
        Wind wind = new Wind();

        if (Optional.ofNullable(windXml.getSpeedMin()).isPresent()) {
            wind.setMin(windXml.getSpeedMin());
        }
        if (Optional.ofNullable(windXml.getSpeedMax()).isPresent()) {
            wind.setMax(windXml.getSpeedMax());
        }

        for (WindType value : WindType.values()) {
            if (value.getName().equalsIgnoreCase(windXml.getDirection())) {
                wind.setType(value);
            }
        }

        return wind;
    }
}
