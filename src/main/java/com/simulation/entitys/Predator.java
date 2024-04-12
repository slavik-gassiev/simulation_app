package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.CoordinatesShift;
import com.simulation.EntityName;

public class Predator extends Creature {

    public Predator(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint) {
        super(coordinates, entityName, speed, healfPoint);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void makeMove(CoordinatesShift coordinatesShift) {
        
    }

}
