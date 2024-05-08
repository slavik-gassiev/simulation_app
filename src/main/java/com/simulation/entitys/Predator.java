package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.map.Map;
import com.simulation.entitys.moves.PredatoreMoves;
import java.util.Random;

public class Predator extends Creature {
    Integer hitStrength;
    PredatoreMoves predatoreMoves;
    Random random = new Random();

    public Predator(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint, Integer hitStrength, PredatoreMoves predatoreMoves) {
        super(coordinates, entityName, speed, healfPoint);
        this.hitStrength = hitStrength;
        this.predatoreMoves = predatoreMoves;
    }

    @Override
    public void makeMove(Map map) {
        predatoreMoves.move(map, coordinates, entityName, speed, healfPoint, hitStrength);
    }

}
