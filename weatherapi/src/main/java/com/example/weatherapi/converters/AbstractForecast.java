package com.example.weatherapi.converters;

import com.example.weatherapi.model.forecast.Place;
import com.example.weatherapi.model.forecast.Temperature;
import com.example.weatherapi.model.forecastxml.PlaceXml;
import com.example.weatherapi.model.forecastxml.TimeOfDayXml;
import com.example.weatherapi.model.forecastxml.WindXml;

import java.util.Optional;

public class AbstractForecast {

    private final TemperatureXmlToTemperature temperatureXmlToTemperature;

    private final WindXmlToPlace windXmlToWind;

    public AbstractForecast(TemperatureXmlToTemperature temperatureXmlToTemperature, WindXmlToPlace windXmlToWind) {
        this.temperatureXmlToTemperature = temperatureXmlToTemperature;
        this.windXmlToWind = windXmlToWind;
    }

    protected Place placeXmlToPlace(PlaceXml placeXml, TimeOfDayXml timeOfDayXml) {
        Optional<Place> optionalPlace = Optional.ofNullable(temperatureXmlToTemperature.convert(placeXml));
        if (optionalPlace.isPresent()) {
            Place place = optionalPlace.get();

            Temperature temperature = place.getPrediction().getTemperature();

            if (!Optional.ofNullable(temperature.getMin()).isPresent()) {
                temperature.setMin(timeOfDayXml.getTempMin());
            }
            if (!Optional.ofNullable(temperature.getMax()).isPresent()) {
                temperature.setMax(timeOfDayXml.getTempMax());
            }

            place.getPrediction().setTemperature(temperature);

            return place;
        }

        return new Place();
    }

    protected Place windXmlToWind(WindXml windXml) {
        return windXmlToWind.convert(windXml);
    }
}
