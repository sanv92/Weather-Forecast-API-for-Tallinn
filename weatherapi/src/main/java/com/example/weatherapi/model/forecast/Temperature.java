package com.example.weatherapi.model.forecast;

import com.example.weatherapi.model.PhenomenonType;

import java.util.Objects;

public class Temperature {

    private PhenomenonType phenomenon;

    private Integer min;

    private Integer max;

    public Temperature() {
    }

    public Temperature(PhenomenonType phenomenon, Integer min, Integer max) {
        this.phenomenon = phenomenon;
        this.min = min;
        this.max = max;
    }

    public Integer getMin() {
        return min;
    }

    public Temperature setMin(Integer min) {
        this.min = min;
        return this;
    }

    public Integer getMax() {
        return max;
    }

    public Temperature setMax(Integer max) {
        this.max = max;
        return this;
    }

    public PhenomenonType getPhenomenon() {
        return phenomenon;
    }

    public Temperature setPhenomenon(PhenomenonType phenomenon) {
        this.phenomenon = phenomenon;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Temperature)) return false;
        Temperature that = (Temperature) o;
        return phenomenon == that.phenomenon &&
                Objects.equals(min, that.min) &&
                Objects.equals(max, that.max);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phenomenon, min, max);
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "phenomenon=" + phenomenon +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
