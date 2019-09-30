package com.example.weatherapi.converters;

import com.example.weatherapi.model.PhenomenonType;
import com.example.weatherapi.model.PlaceType;
import com.example.weatherapi.model.TimeOfDayType;
import com.example.weatherapi.model.WindType;
import com.example.weatherapi.model.forecast.*;
import com.example.weatherapi.model.forecastxml.*;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

class ForecastGroupXmlToForecastsTest {

    private ForecastGroupXmlToForecasts forecastsXmlToForecasts;

    @BeforeEach
    void setUp() {
        this.forecastsXmlToForecasts = new ForecastGroupXmlToForecasts(
                new ForecastNightXmlToForecast(new TemperatureXmlToTemperature(), new WindXmlToPlace()),
                new ForecastDayXmlToForecast(new TemperatureXmlToTemperature(), new WindXmlToPlace())
        );
    }

    @Nested
    @DisplayName("convert with temperature")
    class TestConverterWithTemperature {

        @Test
        @DisplayName("should convert ForecastGroupXml object with temperature to List<Forecast>")
        void convert_ForecastGroupXml_to_ListForecast() {
            List<Forecast> result = forecastsXmlToForecasts.convert(createForecastGroupXml());
            List<Forecast> expectedResult = createListForecast();

            Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
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

        private List<Forecast> createListForecast() {
            return Arrays.asList(
                    new Forecast()
                            .setDate(LocalDate.of(2019, 9, 28))
                            .setTimeOfDayType(TimeOfDayType.NIGHT)
                            .setDescription("text example 1")
                            .setPlaces(Arrays.asList(
                                    new Place()
                                            .setPlaceType(PlaceType.HARKU)
                                            .setPrediction(
                                                    new Prediction()
                                                            .setTemperature(
                                                                    new Temperature()
                                                                            .setPhenomenon(PhenomenonType.VARIABLE_CLOUDS)
                                                                            .setMin(4)
                                                                            .setMax(11)
                                                            )
                                            )
                            )),
                    new Forecast()
                            .setDate(LocalDate.of(2019, 9, 28))
                            .setTimeOfDayType(TimeOfDayType.DAY)
                            .setDescription("text example 2")
                            .setPlaces(Arrays.asList(
                                    new Place()
                                            .setPlaceType(PlaceType.TARTU)
                                            .setPrediction(
                                                    new Prediction()
                                                            .setTemperature(
                                                                    new Temperature()
                                                                            .setPhenomenon(PhenomenonType.LIGHT_SHOWER)
                                                                            .setMin(12)
                                                                            .setMax(14)
                                                            )
                                            )
                            ))
            );
        }
    }

    @Nested
    @DisplayName("convert with wind")
    class TestConverterWithWind {

        @Test
        @DisplayName("should convert ForecastGroupXml object with wind to List<Forecast>")
        void convert_ForecastGroupXml_to_ListForecast() {
            List<Forecast> result = forecastsXmlToForecasts.convert(createForecastGroupXml());
            List<Forecast> expectedResult = createListForecast();

            Assertions.assertArrayEquals(expectedResult.toArray(), result.toArray());
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
                                            .setWinds(Arrays.asList(
                                                    new WindXml()
                                                            .setName("Kuusiku")
                                                            .setDirection("East wind")
                                                            .setSpeedMin(2)
                                                            .setSpeedMax(6)
                                            )),
                                    new TimeOfDayXml()
                                            .setPhenomenon("Moderate shower")
                                            .setTempMin(12)
                                            .setTempMax(16)
                                            .setText("text example 2")
                                            .setWinds(Arrays.asList(
                                                    new WindXml()
                                                            .setName("Väike-Maarja")
                                                            .setDirection("Southeast wind")
                                                            .setSpeedMin(2)
                                                            .setSpeedMax(5)
                                            ))
                            )
                    )
            );
        }

        private List<Forecast> createListForecast() {
            return Arrays.asList(
                    new Forecast()
                            .setUuid(null)
                            .setDate(LocalDate.of(2019, 9, 28))
                            .setTimeOfDayType(TimeOfDayType.NIGHT)
                            .setDescription("text example 1")
                            .setPlaces(Arrays.asList(
                                    new Place()
                                            .setUuid(null)
                                            .setPlaceType(PlaceType.KUUSIKU)
                                            .setPrediction(
                                                    new Prediction()
                                                            .setWind(
                                                                    new Wind()
                                                                        .setType(WindType.EAST_WIND)
                                                                        .setMin(2)
                                                                        .setMax(6)
                                                            )
                                            )
                            )),
                    new Forecast()
                            .setUuid(null)
                            .setDate(LocalDate.of(2019, 9, 28))
                            .setTimeOfDayType(TimeOfDayType.DAY)
                            .setDescription("text example 2")
                            .setPlaces(Arrays.asList(
                                    new Place()
                                            .setUuid(null)
                                            .setPlaceType(PlaceType.VAIKE_MAARJA)
                                            .setPrediction(
                                                    new Prediction()
                                                            .setWind(
                                                                    new Wind()
                                                                            .setType(WindType.SOUTHEAST_WIND)
                                                                            .setMin(2)
                                                                            .setMax(5)
                                                            )
                                            )
                            ))
            );
        }
    }
}