package com.example.weatherapi.model.forecast;

import com.example.weatherapi.model.WindType;

import java.util.Objects;

public class Wind {

    private WindType type;

    private int min;

    private int max;

    public Wind() {
        this.min = 0;
        this.max = 0;
    }

    public Wind(WindType type, int min, int max) {
        this.type = type;
        this.min = min;
        this.max = max;
    }

    public WindType getType() {
        return type;
    }

    public Wind setType(WindType type) {
        this.type = type;
        return this;
    }

    public int getMin() {
        return min;
    }

    public Wind setMin(int min) {
        this.min = min;
        return this;
    }

    public int getMax() {
        return max;
    }

    public Wind setMax(int max) {
        this.max = max;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Wind)) return false;
        Wind wind = (Wind) o;
        return min == wind.min &&
                max == wind.max &&
                type == wind.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, min, max);
    }

    @Override
    public String toString() {
        return "Wind{" +
                "type=" + type +
                ", min=" + min +
                ", max=" + max +
                '}';
    }
}
