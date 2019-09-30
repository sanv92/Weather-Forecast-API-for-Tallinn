package com.example.weatherapi;

import com.example.weatherapi.model.PhenomenonType;
import com.example.weatherapi.model.PlaceType;
import com.example.weatherapi.model.TimeOfDayType;
import com.example.weatherapi.model.WindType;
import com.example.weatherapi.model.forecast.Forecast;
import com.example.weatherapi.model.forecast.Place;
import com.example.weatherapi.model.forecastxml.ForecastGroupXml;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WeatherApi extends BaseApi {

    private ConversionService conversionService;

    private static final String API_URL = "/ilma_andmed/xml/forecast.php";

    public WeatherApi() {
    }

    public WeatherApi(WeatherProperties properties, RestTemplate restTemplate, ConversionService conversionService) {
        super(properties, restTemplate);
        this.conversionService = conversionService;
    }

    public List<Forecast> findAll() {
        return getAllForecasts();
    }

    public List<Forecast> findAll(Function<List<Forecast>, List<Forecast>> fn) {
        return fn.apply(getAllForecasts());
    }

    private List<Forecast> getAllForecasts() {
        Optional<ForecastGroupXml> forecastGroup = doRequest(API_URL);
        if (!forecastGroup.isPresent()) {
            return Collections.emptyList();
        }

        TypeDescriptor sourceType = TypeDescriptor.valueOf(ForecastGroupXml.class);
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Forecast.class));
        if (conversionService.canConvert(sourceType, targetType)) {
            return (List<Forecast>) conversionService
                    .convert(forecastGroup.get(), sourceType, targetType);
        }

        return Collections.emptyList();
    }

    public static List<Forecast> filterPlacesByTemperatureType(List<Forecast> forecasts) {
        for (Forecast forecast : forecasts) {
            forecast.setPlaces(
                    filterPlacesByTemperature(forecast.getPlaces())
            );
        }

        return forecasts;
    }

    private static List<Place> filterPlacesByTemperature(List<Place> places) {
        return places.stream()
                .filter(place -> Optional.ofNullable(place.getPrediction().getTemperature()).isPresent())
                .collect(Collectors.toList());
    }

    public static List<Forecast> filterPlacesByWindType(List<Forecast> forecasts) {
        for (Forecast forecast : forecasts) {
            forecast.setPlaces(
                    filterPlacesByWind(forecast.getPlaces())
            );
        }

        return forecasts;
    }

    private static List<Place> filterPlacesByWind(List<Place> places) {
        return places.stream()
                .filter(place -> Optional.ofNullable(place.getPrediction().getWind()).isPresent())
                .collect(Collectors.toList());
    }

    public List<PlaceType> findPlaceTypes() {
        return Arrays.stream(PlaceType.values())
                .collect(Collectors.toList());
    }

    public List<WindType> findWindTypes() {
        return Arrays.stream(WindType.values())
                .collect(Collectors.toList());
    }

    public List<PhenomenonType> findPhenomenonTypes() {
        return Arrays.stream(PhenomenonType.values())
                .collect(Collectors.toList());
    }

    public List<TimeOfDayType> findTimeOfDayTypes() {
        return Arrays.stream(TimeOfDayType.values())
                .collect(Collectors.toList());
    }
}
