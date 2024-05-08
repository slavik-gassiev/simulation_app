package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.map.Map;

public class Grass extends Entity {

    public Grass(Coordinates coordinates, EntityName entityName) {
        super(coordinates, entityName);
    }

    @Override
    public void makeMove(Map map) {
    }

}
