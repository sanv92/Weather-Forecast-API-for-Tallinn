package com.example.weatherapi.converters;

import com.example.weatherapi.model.TimeOfDayType;
import com.example.weatherapi.model.forecast.Forecast;
import com.example.weatherapi.model.forecastxml.ForecastXml;
import com.example.weatherapi.model.forecastxml.PlaceXml;
import com.example.weatherapi.model.forecastxml.WindXml;
import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.util.UUID;

public class ForecastNightXmlToForecast extends AbstractForecast implements Converter<ForecastXml, Forecast> {

    public ForecastNightXmlToForecast(TemperatureXmlToTemperature temperatureXmlToTemperature, WindXmlToPlace windXmlToWind) {
        super(temperatureXmlToTemperature, windXmlToWind);
    }

    @Override
    public Forecast convert(ForecastXml forecastXml) {
        Forecast forecast = new Forecast();
        forecast.setUuid(UUID.randomUUID());
        forecast.setDate(LocalDate.parse(forecastXml.getDate()));

        forecast.setDescription(forecastXml.getNight().getText());
        forecast.setTimeOfDayType(TimeOfDayType.NIGHT);

        for(PlaceXml placeXml : forecastXml.getNight().getPlaces()) {
            forecast.getPlaces().add(
                    placeXmlToPlace(placeXml, forecastXml.getNight())
            );
        }
        for(WindXml windXml : forecastXml.getNight().getWinds()) {
            forecast.getPlaces().add(
                    windXmlToWind(windXml)
            );
        }

        return forecast;
    }
}
