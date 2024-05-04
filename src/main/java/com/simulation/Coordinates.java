package com.simulation;

import java.util.Objects;

public class Coordinates {
    public int longitude;
    public int latitude;

    public Coordinates(Integer longitude, Integer latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return longitude == that.longitude && latitude == that.latitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(longitude, latitude);
    }
}
