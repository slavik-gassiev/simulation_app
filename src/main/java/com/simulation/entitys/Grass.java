package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.Map;

public class Grass extends Entity{

    public Grass(Coordinates coordinates, EntityName entityName) {
        super(coordinates, entityName);
        
        // this.coordinates = coordinates;
        // this.entityName = entityName;
    }

    @Override
    public void makeMove(Map map) {
        System.out.println("Grass");
    }

}
