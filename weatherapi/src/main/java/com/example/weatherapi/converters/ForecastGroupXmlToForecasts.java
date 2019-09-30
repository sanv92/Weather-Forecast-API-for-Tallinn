package com.example.weatherapi.converters;

import com.example.weatherapi.model.forecast.Forecast;
import com.example.weatherapi.model.forecastxml.ForecastGroupXml;
import com.example.weatherapi.model.forecastxml.ForecastXml;
import org.springframework.core.convert.converter.Converter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForecastGroupXmlToForecasts implements Converter<ForecastGroupXml, List<Forecast>> {

    private final ForecastNightXmlToForecast forecastNightXmlToForecast;

    private final ForecastDayXmlToForecast forecastDayXmlToForecast;

    public ForecastGroupXmlToForecasts(ForecastNightXmlToForecast forecastNightXmlToForecast, ForecastDayXmlToForecast forecastDayXmlToForecast) {
        this.forecastNightXmlToForecast = forecastNightXmlToForecast;
        this.forecastDayXmlToForecast = forecastDayXmlToForecast;
    }

    @Override
    public List<Forecast> convert(ForecastGroupXml forecastGroupXml) {
        List<Forecast> forecasts = new ArrayList<>();

        for (ForecastXml forecast : forecastGroupXml.getForecasts()) {
            forecasts.addAll(
                    Arrays.asList(
                            forecastNightXmlToForecast.convert(forecast),
                            forecastDayXmlToForecast.convert(forecast)
                    )
            );
        }

        return forecasts;
    }
}
