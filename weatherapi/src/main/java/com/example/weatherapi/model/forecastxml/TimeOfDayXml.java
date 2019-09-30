package com.example.weatherapi.model.forecastxml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeOfDayXml {

    @JacksonXmlProperty(localName = "phenomenon")
    private String phenomenon;

    @JacksonXmlProperty(localName = "tempmin")
    private Integer tempMin;

    @JacksonXmlProperty(localName = "tempmax")
    private Integer tempMax;

    @JacksonXmlProperty(localName = "text")
    private String text;

    @JacksonXmlElementWrapper(localName = "place", useWrapping = false)
    @JacksonXmlProperty(localName = "place")
    private List<PlaceXml> places;

    @JacksonXmlElementWrapper(localName = "wind", useWrapping = false)
    @JacksonXmlProperty(localName = "wind")
    private List<WindXml> winds;

    public TimeOfDayXml() {
        this.places = new ArrayList<>();
        this.winds = new ArrayList<>();
    }

    public TimeOfDayXml(String phenomenon, Integer tempMin, Integer tempMax, String text, List<PlaceXml> places, List<WindXml> winds) {
        this.phenomenon = phenomenon;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.text = text;
        this.places = places;
        this.winds = winds;
    }

    public String getPhenomenon() {
        return phenomenon;
    }

    public TimeOfDayXml setPhenomenon(String phenomenon) {
        this.phenomenon = phenomenon;
        return this;
    }

    public Integer getTempMin() {
        return tempMin;
    }

    public TimeOfDayXml setTempMin(Integer tempMin) {
        this.tempMin = tempMin;
        return this;
    }

    public Integer getTempMax() {
        return tempMax;
    }

    public TimeOfDayXml setTempMax(Integer tempMax) {
        this.tempMax = tempMax;
        return this;
    }

    public String getText() {
        return text;
    }

    public TimeOfDayXml setText(String text) {
        this.text = text;
        return this;
    }

    public List<PlaceXml> getPlaces() {
        return places;
    }

    public TimeOfDayXml setPlaces(List<PlaceXml> places) {
        this.places = places;
        return this;
    }

    public List<WindXml> getWinds() {
        return winds;
    }

    public TimeOfDayXml setWinds(List<WindXml> winds) {
        this.winds = winds;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeOfDayXml)) return false;
        TimeOfDayXml timeOfDay = (TimeOfDayXml) o;
        return Objects.equals(phenomenon, timeOfDay.phenomenon) &&
                Objects.equals(tempMin, timeOfDay.tempMin) &&
                Objects.equals(tempMax, timeOfDay.tempMax) &&
                Objects.equals(text, timeOfDay.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phenomenon, tempMin, tempMax, text);
    }

    @Override
    public String toString() {
        return "TimeOfDay{" +
                "phenomenon='" + phenomenon + '\'' +
                ", tempMin='" + tempMin + '\'' +
                ", tempMax='" + tempMax + '\'' +
                ", text='" + text + '\'' +
                ", places=" + places +
                ", winds=" + winds +
                '}';
    }
}
