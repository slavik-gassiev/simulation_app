package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.Map;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Predator extends Creature {
    Integer hitStrength;

    Random random = new Random();


    public Predator(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint, Integer hitStrength) {
        super(coordinates, entityName, speed, healfPoint);
        this.hitStrength = hitStrength;
    }

    @Override
    public void makeMove(Map map) {
        Set<Coordinates> speedSquares = map.getSpeedSquares(this.speed, this.coordinates);
        List<Coordinates> availableSquares = new LinkedList<>();
        boolean shifted = false;

        for (Coordinates coordinates : speedSquares) {
            if (!(map.isSquareAvailableForEntity(coordinates, EntityName.HERBIVORE))) continue;
            if (map.isEntityClose(this.coordinates, coordinates, EntityName.HERBIVORE)) {
                map.hitEntity(coordinates, this.hitStrength);
                if (map.isEntityHPLow(coordinates)) {
                    map.eatEntity(this.coordinates, coordinates);
                    shifted = true;
                    break;
                }
            } else {
                shifted = false;
                availableSquares.add(coordinates);
            }

        }

        if (!shifted) {
            int randomInt = random.nextInt(availableSquares.size());
            Coordinates randomCoordinates = availableSquares.get(randomInt);
            map.shiftEntity(this.coordinates, randomCoordinates);
        }

    }


}
