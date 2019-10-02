package com.example.weatherapi.model.forecast;

import com.example.weatherapi.model.PlaceType;

import java.util.Objects;
import java.util.UUID;

public class Place {

    private UUID uuid;

    private PlaceType type;

    private Prediction prediction;

    public Place() {}

    public Place(PlaceType type, Prediction prediction) {
        this.type = type;
        this.prediction = prediction;
    }

    public PlaceType getType() {
        return type;
    }

    public Place setType(PlaceType type) {
        this.type = type;
        return this;
    }

    public Prediction getPrediction() {
        return prediction;
    }

    public Place setPrediction(Prediction prediction) {
        this.prediction = prediction;
        return this;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Place setUuid(UUID uuid) {
        this.uuid = uuid;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place)) return false;
        Place place = (Place) o;
        return this.type == place.type &&
                Objects.equals(prediction, place.prediction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, prediction);
    }

    @Override
    public String toString() {
        return "Place{" +
                "type=" + type +
                ", prediction=" + prediction +
                '}';
    }
}
