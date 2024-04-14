package com.simulation.entitys;

import java.util.Set;

import com.simulation.Coordinates;
import com.simulation.CoordinatesShift;
import com.simulation.EntityName;
import com.simulation.Map;

public class Predator extends Creature {

    Coordinates coordinates;
    EntityName entityName;
    Integer speed;
    Integer healfPoint;
    Integer hitStrength;


    public Predator(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint, Integer hitStrength) {
        super(coordinates, entityName, speed, healfPoint);
        
        this.coordinates = coordinates;
        this.entityName = entityName;
        this.speed = speed;
        this.healfPoint = healfPoint;
        this.hitStrength = hitStrength;
    }

    @Override
    protected void makeMove(Map map) {
        Set<Coordinates> speedSquares = map.getSpeedSquares(this.speed, this.coordinates);
        Predator newPredator = new Predator(this.coordinates, this.entityName, this.speed, this.healfPoint, this.hitStrength);
        for (Coordinates coordinates : speedSquares) {
            if(!(map.isSquareAvailableForEntity(coordinates, this.entityName))) continue;
            if(map.isEntityClose(this.coordinates, coordinates, EntityName.HERBIVORE)) {
                // newPredator.healfPoint += 1;
                // map.eatEntity(coordinates, newPredator);
                if(map.isEntityHasLowHP(coordinates, EntityName.HERBIVORE){

                }
            }
            newPredator.healfPoint -= 1;
            map.shiftEntity(coordinates, newPredator);
            
        }
        
    }

   

}
