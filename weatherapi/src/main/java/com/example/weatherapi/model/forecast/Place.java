package com.example.weatherapi.model.forecast;

import com.example.weatherapi.model.PlaceType;
import com.example.weatherapi.serializer.EnumTypeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Objects;
import java.util.UUID;

public class Place {

    private UUID uuid;

    @JsonSerialize(using = EnumTypeSerializer.class)
    private PlaceType placeType;

    private Prediction prediction;

    public Place() {}

    public Place(PlaceType placeType, Prediction prediction) {
        this.placeType = placeType;
        this.prediction = prediction;
    }

    public PlaceType getPlaceType() {
        return placeType;
    }

    public Place setPlaceType(PlaceType placeType) {
        this.placeType = placeType;
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
        return placeType == place.placeType &&
                Objects.equals(prediction, place.prediction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(placeType, prediction);
    }

    @Override
    public String toString() {
        return "Place{" +
                "placeType=" + placeType +
                ", prediction=" + prediction +
                '}';
    }
}
