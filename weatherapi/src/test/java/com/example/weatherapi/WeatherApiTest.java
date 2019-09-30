package com.example.weatherapi;

import com.example.weatherapi.model.PhenomenonType;
import com.example.weatherapi.model.PlaceType;
import com.example.weatherapi.model.TimeOfDayType;
import com.example.weatherapi.model.forecast.Forecast;
import com.example.weatherapi.model.forecast.Place;
import com.example.weatherapi.model.forecast.Prediction;
import com.example.weatherapi.model.forecast.Temperature;
import com.example.weatherapi.model.forecastxml.ForecastGroupXml;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class WeatherApiTest extends AbstractTest {

    @Mock
    private ConversionService conversionService;

    @Mock
    private RestTemplate restTemplate;

    @Spy
    private WeatherApi weatherApi;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        this.weatherApi = new WeatherApi(
                new WeatherProperties(),
                restTemplate,
                conversionService
        );
    }

    @Test
    void findAll() throws IOException {
        when(restTemplate.getForEntity(anyString(), any())).thenReturn(
                ResponseEntity.of(Optional.of(
                        readFileFromFixtures("forecasts-small-temperature.xml")
                ))
        );
        when(conversionService.canConvert(any(TypeDescriptor.class), any(TypeDescriptor.class)))
                .thenReturn(true);
        when(conversionService.convert(any(ForecastGroupXml.class), any(TypeDescriptor.class), any(TypeDescriptor.class)))
                .thenReturn(createForecasts());

        List<Forecast> expectedResult = createForecasts();
        List<Forecast> result = weatherApi.findAll();
        Assert.assertArrayEquals(expectedResult.toArray(), result.toArray());

        List<Forecast> result2 = weatherApi.findAll(WeatherApi::filterPlacesByWindType);
        Assert.assertArrayEquals(expectedResult.toArray(), result.toArray());

        List<Forecast> result3 = weatherApi.findAll(WeatherApi::filterPlacesByTemperatureType);
        Assert.assertArrayEquals(expectedResult.toArray(), result2.toArray());

        Assert.assertArrayEquals(expectedResult.toArray(), result3.toArray());
    }

    @Test
    void getEmptyCollection_WhenCallFindAll() {
        WeatherApi weatherApi = spy(WeatherApi.class);
        doReturn(Optional.empty()).when(weatherApi).doRequest(anyString());

        List<Forecast> expectedResult = Collections.emptyList();
        List<Forecast> result = weatherApi.findAll();

        verify(weatherApi, times(1)).doRequest(anyString());

        Assert.assertArrayEquals(expectedResult.toArray(), result.toArray());
    }

    @Test
    void getEmpty_WhenCallDoRequest() {
        when(restTemplate.getForEntity(anyString(), any())).thenReturn(
                ResponseEntity.of(Optional.empty())
        );

        Optional<ForecastGroupXml> expectedResult = Optional.empty();
        Optional<ForecastGroupXml> result = weatherApi.doRequest("test");

        Assert.assertEquals(expectedResult, result);
    }

    private List<Forecast> createForecasts() {
        return Arrays.asList(createForecast(), createForecast());
    }

    private Forecast createForecast() {
        return new Forecast()
                .setUuid(UUID.fromString("38400000-8cf0-11bd-b23e-10b96e4ef00d"))
                .setDate(LocalDate.of(2019, 7, 11))
                .setDescription("description 1")
                .setTimeOfDayType(TimeOfDayType.DAY)
                .setPlaces(
                        Arrays.asList(createPlace(), createPlace())
                );
    }

    private Place createPlace() {
        return new Place()
                .setUuid(UUID.fromString("18400000-8cf0-11bd-b23e-10b96e4ef00a"))
                .setPlaceType(PlaceType.TARTU)
                .setPrediction(
                        new Prediction()
                                .setTemperature(
                                        new Temperature()
                                                .setPhenomenon(PhenomenonType.VARIABLE_CLOUDS)
                                                .setMin(4)
                                                .setMax(11)
                                )
                );
    }
}