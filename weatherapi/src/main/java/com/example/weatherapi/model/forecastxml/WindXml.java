package com.example.weatherapi.model.forecastxml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WindXml {

    @JacksonXmlProperty(localName = "name")
    private String name;

    @JacksonXmlProperty(localName = "direction")
    private String direction;

    @JacksonXmlProperty(localName = "speedmin")
    private Integer speedMin;

    @JacksonXmlProperty(localName = "speedmax")
    private Integer speedMax;

    public WindXml() {}

    public WindXml(String name, String direction) {
        this.name = name;
        this.direction = direction;
    }

    public WindXml(String name, String direction, Integer speedMin) {
        this.name = name;
        this.direction = direction;
        this.speedMin = speedMin;
    }

    public WindXml(String name, String direction, Integer speedMin, Integer speedMax) {
        this.name = name;
        this.direction = direction;
        this.speedMin = speedMin;
        this.speedMax = speedMax;
    }

    public String getName() {
        return name;
    }

    public WindXml setName(String name) {
        this.name = name;
        return this;
    }

    public String getDirection() {
        return direction;
    }

    public WindXml setDirection(String direction) {
        this.direction = direction;
        return this;
    }

    public Integer getSpeedMin() {
        return speedMin;
    }

    public WindXml setSpeedMin(Integer speedMin) {
        this.speedMin = speedMin;
        return this;
    }

    public Integer getSpeedMax() {
        return speedMax;
    }

    public WindXml setSpeedMax(Integer speedMax) {
        this.speedMax = speedMax;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WindXml)) return false;
        WindXml wind = (WindXml) o;
        return Objects.equals(name, wind.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Wind{" +
                "name='" + name + '\'' +
                ", direction='" + direction + '\'' +
                ", speedMin=" + speedMin +
                ", speedMax=" + speedMax +
                '}';
    }
}
