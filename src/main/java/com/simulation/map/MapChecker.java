package com.simulation.map;

import com.simulation.Coordinates;
import java.util.HashSet;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class MapChecker {
    public static final Random random = new Random();

    public static boolean isSquareInMapAvailable(Coordinates coordinates) {
        return (coordinates.height <= 8 && coordinates.weight <= 8) && (coordinates.height >= 1 && coordinates.weight >= 1);
    }

    public static Set<Coordinates> getSpeedSquares(Integer speed, Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();
        for (int height = -speed; height <= speed; height++) {
            for (int weight = -speed; weight < speed; weight++) {
                if (height == 0 && weight == 0) continue;
                Coordinates newCoordinates = new Coordinates(coordinates.height + height, coordinates.weight + weight);
                if (!(isSquareInMapAvailable(newCoordinates))) continue;
                result.add(newCoordinates);
            }
        }
        return result;
    }

    public  static boolean isSquareEmpty(Coordinates coordinates) {
        return !(Map.getEntitys().containsKey(coordinates));
    }

    public static boolean isSquareClose(Coordinates sourceCoordinates, Coordinates checkingCoordinates) {
        if (isSquareEmpty(checkingCoordinates)) {
            return false;
        }

        Set<Coordinates> closeCoordinates = new HashSet<>();

        for (int lon = -1; lon < 2; lon++) {
            for (int lat = -1; lat < 2; lat++) {
                if (lat == 0 && lon == 0) continue;
                Coordinates coordinates = new Coordinates(checkingCoordinates.height + lon, checkingCoordinates.weight + lat);
                closeCoordinates.add(coordinates);
            }
        }

        for (Coordinates coordinates : closeCoordinates) {
            if (!(isSquareInMapAvailable(coordinates))) continue;
            if (Objects.equals(coordinates, sourceCoordinates)) {
                return true;
            }
        }
        return false;
    }

    public static Coordinates getRandomCoordinates() {
        Coordinates randomCoordinates;

        while (true) {
            randomCoordinates = new Coordinates(random.nextInt(8), random.nextInt(8));
            if (((randomCoordinates.height < 1) || (randomCoordinates.weight < 1))) continue;
            if (!(isSquareEmpty(randomCoordinates))) continue;
            return randomCoordinates;
        }
    }
}

