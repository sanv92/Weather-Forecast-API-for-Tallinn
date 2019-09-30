package com.example.weatherapi.model;

import com.example.weatherapi.serializer.EnumTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumTypeSerializer.class)
public enum WindType implements ForecastType {
    NORTH_WIND("North Wind"),
    SOUTH_WIND("South Wind"),
    EAST_WIND("East Wind"),
    WEST_WIND("West Wind"),
    NORTHEAST_WIND("Northeast Wind"),
    SOUTHEAST_WIND("Southeast Wind"),
    SOUTHWEST_WIND("Southwest Wind"),
    NORTHWEST_WIND("Northwest Wind"),
    NORTHERLY_WIND("Northerly winds"),
    SOUTHERLY_WIND("Southerly winds"),
    EASTERLY_WIND("Easterly winds"),
    WESTERLY_WIND("Westerly winds");

    private final String name;

    WindType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
