package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.CoordinatesShift;
import com.simulation.EntityName;
import com.simulation.Map;

public class Herbivore extends Creature {

    Coordinates coordinates;
    EntityName entityName;
    Integer speed;
    Integer healfPoint;

    public Herbivore(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint) {
        super(coordinates, entityName, speed, healfPoint);
        
        this.coordinates = coordinates;
        this.entityName = entityName;
        this.speed = speed;
        this.healfPoint = healfPoint;
    }

    @Override
    protected void makeMove(CoordinatesShift coordinatesShift) {
        if(Map.canShift(this.coordinates, coordinatesShift))
        this.coordinates.longitude += coordinatesShift.lonShift;
        this.coordinates.latitude += coordinatesShift.latShift;
    }

  

    
    

   

 

}
