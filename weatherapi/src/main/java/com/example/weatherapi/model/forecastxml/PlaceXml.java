package com.example.weatherapi.model.forecastxml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlaceXml {

    @JacksonXmlProperty(localName = "name")
    private String name;

    @JacksonXmlProperty(localName = "phenomenon")
    private String phenomenon;

    @JacksonXmlProperty(localName = "tempmin")
    private Integer tempMin;

    @JacksonXmlProperty(localName = "tempmax")
    private Integer tempMax;

    public PlaceXml() {}

    public PlaceXml(String name, String phenomenon) {
        this.name = name;
        this.phenomenon = phenomenon;
    }

    public PlaceXml(String name, String phenomenon, Integer tempMin) {
        this.name = name;
        this.phenomenon = phenomenon;
        this.tempMin = tempMin;
    }

    public PlaceXml(String name, String phenomenon, Integer tempMin, Integer tempMax) {
        this.name = name;
        this.phenomenon = phenomenon;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
    }

    public String getName() {
        return name;
    }

    public PlaceXml setName(String name) {
        this.name = name;
        return this;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public PlaceXml setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
        return this;
    }

    public Integer getTempMin() {
        return tempMin;
    }

    public PlaceXml setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    public Integer getTempMax() {
        return tempMax;
    }

    public PlaceXml setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaceXml)) return false;
        PlaceXml place = (PlaceXml) o;
        return Objects.equals(name, place.name) &&
                Objects.equals(phenomenon, place.phenomenon) &&
                Objects.equals(tempMin, place.tempMin) &&
                Objects.equals(tempMax, place.tempMax);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, phenomenon, tempMin, tempMax);
    }

    @Override
    public String toString() {
        return "Place{" +
                "name='" + name + '\'' +
                ", phenomenon='" + phenomenon + '\'' +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                '}';
    }
}
