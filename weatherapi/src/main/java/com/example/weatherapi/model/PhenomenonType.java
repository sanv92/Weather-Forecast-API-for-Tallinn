package com.example.weatherapi.model;

import com.example.weatherapi.serializer.EnumTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumTypeSerializer.class)
public enum PhenomenonType implements ForecastType {
    CLEAR("Clear"),
    FEW_CLOUDS("Few clouds"),
    VARIABLE_CLOUDS("Variable clouds"),
    CLOUDY_WITH_CLEAR_SPELLS("Cloudy with clear spells"),
    CLOUDY("Cloudy"),
    LIGHT_SNOW_SHOWER("Light snow shower"),
    MODERATE_SNOW_SHOWER("Moderate snow shower"),
    HEAVY_SNOW_SHOWER("Heavy snow shower"),
    LIGHT_SHOWER("Light shower"),
    MODERATE_SHOWER("Moderate shower"),
    HEAVY_SHOWER("Heavy shower"),
    LIGHT_RAIN("Light rain"),
    MODERATE_RAIN("Moderate rain"),
    HEAVY_RAIN("Heavy rain"),
    RISK_OF_GLAZE("Risk of glaze"),
    LIGHT_SLEET("Light sleet"),
    MODERATE_SLEET("Moderate sleet"),
    LIGHT_SNOWFALL("Light snowfall"),
    MODERATE_SNOWFALL("Moderate snowfall"),
    HEAVY_SNOWFALL("Heavy snowfall"),
    SNOWSTORM("Snowstorm"),
    BLOWING_SNOW("Blowing snow"),
    DRIFTING_SNOW("Drifting snow"),
    HAIL("Hail"),
    MIST("Mist"),
    FOG("Fog"),
    THUNDER("Thunder"),
    THUNDERSTORM("Thunderstorm");

    private final String name;

    PhenomenonType(String name) {
        this.name = name;
    }

    public String getName() {
        return name();
    }

    public String getValue() {
        return name;
    }
}
