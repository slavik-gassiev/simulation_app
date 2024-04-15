package com.simulation.entitys;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Random;

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

    Random random = new Random();


    public Predator(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint, Integer hitStrength) {
        super(coordinates, entityName, speed, healfPoint);
        
        this.coordinates = coordinates;
        this.entityName = entityName;
        this.speed = speed;
        this.healfPoint = healfPoint;
        this.hitStrength = hitStrength;
    }

    @Override
    public void makeMove(Map map) {
        Set<Coordinates> speedSquares = map.getSpeedSquares(this.speed, this.coordinates);
        Predator newPredator = new Predator(this.coordinates, this.entityName, this.speed, this.healfPoint, this.hitStrength);
        List<Coordinates> availableSquares = new LinkedList<>();
        boolean shifted = false;

        for (Coordinates coordinates : speedSquares) {
            if(!(map.isSquareAvailableForEntity(coordinates, this.entityName))) continue;
            if(map.isEntityClose(this.coordinates, coordinates, EntityName.HERBIVORE)) {
                map.hitEntity(coordinates, this.hitStrength);
                if(map.isEntityHPLow(coordinates)) {
                    newPredator.healfPoint += 1;
                    map.eatEntity(coordinates, newPredator);
                    shifted = true;
                    break;
                }          
            } else {
                shifted = false;
                availableSquares.add(coordinates);
            } 
            
        }

        if(!shifted) {
            int randomInt = random.nextInt(availableSquares.size());
            Coordinates randomCoordinates = availableSquares.get(randomInt);
            newPredator.healfPoint -= 1;
            map.shiftEntity(randomCoordinates, newPredator);
        }
        
    }

   

}
