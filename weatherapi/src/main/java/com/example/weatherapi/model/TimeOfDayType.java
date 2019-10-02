package com.example.weatherapi.model;

import com.example.weatherapi.serializer.EnumTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumTypeSerializer.class)
public enum TimeOfDayType implements ForecastType {
    DAY("Day"),
    NIGHT("Night");

    private final String name;

    TimeOfDayType(String name) {
        this.name = name;
    }

    public String getName() {
        return name();
    }

    public String getValue() {
        return name;
    }
}
