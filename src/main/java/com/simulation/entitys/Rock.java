package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.Map;

public class Rock extends Entity {

    public Rock(Coordinates coordinates, EntityName entityName) {
        super(coordinates, entityName);

    }

    @Override
    public void makeMove(Map map) {
        System.out.println("Rock");
    }

}
