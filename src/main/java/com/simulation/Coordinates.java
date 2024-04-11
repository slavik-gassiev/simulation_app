package com.simulation;

public class Coordinates {
    public final Integer longitude;
    public final Integer latitude;
    public Coordinates(Integer longitude, Integer latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((longitude == null) ? 0 : longitude.hashCode());
        result = prime * result + ((latitude == null) ? 0 : latitude.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Coordinates other = (Coordinates) obj;
        if (longitude == null) {
            if (other.longitude != null)
                return false;
        } else if (!longitude.equals(other.longitude))
            return false;
        if (latitude == null) {
            if (other.latitude != null)
                return false;
        } else if (!latitude.equals(other.latitude))
            return false;
        return true;
    }

    
}
