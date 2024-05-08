package com.simulation.entitys.moves;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.entitys.EntityChecker;
import com.simulation.map.Map;
import com.simulation.map.MapChecker;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class BasicPredatoreMove implements PredatoreMoves {
    Random random = new Random();
    @Override
    public void move(Map map, Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint, Integer hitStrength) {
        Set<Coordinates> speedSquares = MapChecker.getSpeedSquares(speed, coordinates);
        List<Coordinates> availableSquares = new LinkedList<>();
        boolean shifted = false;

        for (Coordinates speedCoordinates : speedSquares) {
            if (!(EntityChecker.isSquareAvailableForEntity(speedCoordinates, EntityName.HERBIVORE))) continue;
            if (EntityChecker.isEntityClose(coordinates, speedCoordinates, EntityName.HERBIVORE)) {
                map.hitEntity(coordinates, hitStrength);
                if (EntityChecker.isEntityHPLow(coordinates)) {
                    map.eatEntity(coordinates, speedCoordinates);
                    shifted = true;
                    break;
                }
            } else {
                availableSquares.add(speedCoordinates);
            }

        }

        if (!shifted) {
            int randomInt = MapChecker.random.nextInt(availableSquares.size());
            Coordinates randomCoordinates = availableSquares.get(randomInt);
            map.shiftEntity(coordinates, randomCoordinates);
        }
    }
}
