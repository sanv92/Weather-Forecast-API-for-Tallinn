package com.example.weatherapi.model;

import com.example.weatherapi.serializer.EnumTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumTypeSerializer.class)
public enum PlaceType implements ForecastType {
    HARKU("Harku"),
    JOHVI("Jõhvi"),
    TARTU("Tartu"),
    PARNU("Pärnu"),
    KURESSAARE("Kuressaare"),
    TURI("Türi"),
    KUUSIKU("Kuusiku"),
    VAIKE_MAARJA("Väike-Maarja"),
    VORTSJARV("Võrtsjärv");

    private final String name;

    PlaceType(String name) {
        this.name = name;
    }

    public String getName() {
        return name();
    }

    public String getValue() {
        return name;
    }
}
