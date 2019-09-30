package com.example.weatherapi.model;

import com.example.weatherapi.serializer.EnumTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumTypeSerializer.class)
public enum LanguageType implements ForecastType {
    ENG("eng"),
    EST("est"),
    RUS("rus");

    private final String name;

    LanguageType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
