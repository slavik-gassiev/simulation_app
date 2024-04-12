package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.CoordinatesShift;
import com.simulation.EntityName;

public abstract class Creature extends Entity {

    public Integer speed;
    public Integer healfPoint;

    public Creature(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint) {
        super(coordinates, entityName);
        
        this.speed = speed;
        this.healfPoint = healfPoint;
    }

    protected abstract void makeMove(CoordinatesShift coordinatesShift);

}
