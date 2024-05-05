package com.simulation;

import java.util.Objects;

public class Coordinates {
    public int height;
    public int weight;

    public Coordinates(Integer height, Integer weight) {
        this.height = height;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return height == that.height && weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height, weight);
    }
}
