package com.example.weatherapi.mappers;

import com.example.weatherapi.AbstractTest;
import com.example.weatherapi.model.forecastxml.ForecastGroupXml;
import com.example.weatherapi.model.forecastxml.ForecastXml;
import com.example.weatherapi.model.forecastxml.PlaceXml;
import com.example.weatherapi.model.forecastxml.TimeOfDayXml;
import com.fasterxml.jackson.databind.RuntimeJsonMappingException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MapperFactoryTest extends AbstractTest {

    @Test
    @DisplayName("should convert XML to objects, using application/xml type")
    public void xmlMapper() throws IOException {
        ForecastGroupXml forecastGroupXml = new MapperFactory.Builder()
                .withContent(readFileFromFixtures("forecasts-small-temperature.xml"))
                .map(MediaType.APPLICATION_XML);

        Assertions.assertThat(
                createForecastGroupXml()
        ).isEqualToComparingFieldByFieldRecursively(
                forecastGroupXml
        );
    }

    @Test
    @DisplayName("throw an exception when JSON does not deserialize into object, using application/xml type")
    public void throwJsonMappingException_jsonMapper() {
        assertThrows(RuntimeJsonMappingException.class,
                () -> new MapperFactory.Builder()
                        .withContent(readFileFromFixtures("forecasts-small-temperature.xml"))
                        .map(MediaType.APPLICATION_JSON)
        );
    }

    private ForecastGroupXml createForecastGroupXml() {
        return new ForecastGroupXml(
                Arrays.asList(
                        new ForecastXml(
                                "2019-09-28",
                                new TimeOfDayXml()
                                    .setPhenomenon("Variable clouds")
                                    .setTempMin(0)
                                    .setTempMax(11)
                                    .setText("text example 1")
                                    .setPlaces(Arrays.asList(
                                            new PlaceXml()
                                            .setName("Harku")
                                            .setPhenomenon("Variable clouds")
                                            .setTempMin(4)
                                    )),
                                new TimeOfDayXml()
                                        .setPhenomenon("Moderate shower")
                                        .setTempMin(12)
                                        .setTempMax(16)
                                        .setText("text example 2")
                                        .setPlaces(Arrays.asList(
                                                new PlaceXml()
                                                        .setName("Tartu")
                                                        .setPhenomenon("Light shower")
                                                        .setTempMax(14)
                                        ))
                        )
                )
        );
    }
}