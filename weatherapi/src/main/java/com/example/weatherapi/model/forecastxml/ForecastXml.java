package com.example.weatherapi.model.forecastxml;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ForecastXml {

    @JacksonXmlProperty(localName = "date", isAttribute = true)
    private String date;

    @JacksonXmlElementWrapper(localName = "night")
    @JacksonXmlProperty(localName = "night")
    private TimeOfDayXml night;

    @JacksonXmlElementWrapper(localName = "day")
    @JacksonXmlProperty(localName = "day")
    private TimeOfDayXml day;

    public ForecastXml() {}

    public ForecastXml(String date, TimeOfDayXml night, TimeOfDayXml day) {
        this.date = date;
        this.night = night;
        this.day = day;
    }

    public String getDate() {
        return date;
    }

    public ForecastXml setDate(String date) {
        this.date = date;
        return this;
    }

    public TimeOfDayXml getNight() {
        return night;
    }

    public ForecastXml setNight(TimeOfDayXml night) {
        this.night = night;
        return this;
    }

    public TimeOfDayXml getDay() {
        return day;
    }

    public void setDay(TimeOfDayXml day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ForecastXml)) return false;
        ForecastXml forecast = (ForecastXml) o;
        return Objects.equals(date, forecast.date) &&
                Objects.equals(night, forecast.night) &&
                Objects.equals(day, forecast.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, night, day);
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date=" + date +
                ", night=" + night +
                ", day=" + day +
                '}';
    }
}