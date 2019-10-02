package com.example.weatherapi.model.forecast;

import java.util.Objects;

public class Prediction {

    private Temperature temperature;

    private Wind wind;

    public Prediction() {}

    public Prediction(Temperature temperature, Wind wind) {
        this.temperature = temperature;
        this.wind = wind;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public Prediction setTemperature(Temperature temperature) {
        this.temperature = temperature;
        return this;
    }

    public Wind getWind() {
        return wind;
    }

    public Prediction setWind(Wind wind) {
        this.wind = wind;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Prediction)) return false;
        Prediction that = (Prediction) o;
        return Objects.equals(temperature, that.temperature) &&
                Objects.equals(wind, that.wind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(temperature, wind);
    }

    @Override
    public String toString() {
        return "Prediction{" +
                ", temperature=" + temperature +
                ", wind=" + wind +
                '}';
    }
}
