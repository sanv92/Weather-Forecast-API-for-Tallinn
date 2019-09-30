package com.example.weatherapi.model.forecast;

import com.example.weatherapi.model.TimeOfDayType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Forecast {

    private UUID uuid;

    private LocalDate date;

    private TimeOfDayType timeOfDayType;

    private String description;

    private List<Place> places;

    public Forecast() {
        this.places = new ArrayList<>();
    }

    public Forecast(LocalDate date, TimeOfDayType timeOfDayType, String description) {
        this.date = date;
        this.timeOfDayType = timeOfDayType;
        this.description = description;
        this.places = new ArrayList<>();
    }

    public Forecast(LocalDate date, TimeOfDayType timeOfDayType, String description, List<Place> places) {
        this.date = date;
        this.timeOfDayType = timeOfDayType;
        this.description = description;
        this.places = places;
    }

    public LocalDate getDate() {
        return date;
    }

    public Forecast setDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public TimeOfDayType getTimeOfDayType() {
        return timeOfDayType;
    }

    public Forecast setTimeOfDayType(TimeOfDayType timeOfDayType) {
        this.timeOfDayType = timeOfDayType;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Forecast setDescription(String description) {
        this.description = description;
        return this;
    }

    public List<Place> getPlaces() {
        return places;
    }

    public Forecast setPlaces(List<Place> places) {
        this.places = places;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Forecast setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Forecast)) return false;
        Forecast forecast = (Forecast) o;
        return Objects.equals(date, forecast.date) &&
                timeOfDayType == forecast.timeOfDayType &&
                Objects.equals(description, forecast.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date, timeOfDayType, description);
    }

    @Override
    public String toString() {
        return "Forecast{" +
                "date=" + date +
                ", timeOfDayType=" + timeOfDayType +
                ", description='" + description + '\'' +
                ", places=" + places +
                '}';
    }
}
