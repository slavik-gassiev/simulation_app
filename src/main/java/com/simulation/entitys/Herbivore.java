package com.simulation.entitys;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Random;

import com.simulation.Coordinates;
import com.simulation.CoordinatesShift;
import com.simulation.EntityName;
import com.simulation.Map;


public class Herbivore extends Creature {

    Coordinates coordinates;
    EntityName entityName;
    Integer speed;
    Integer healfPoint;

    Random random = new Random();

    public Herbivore(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint) {
        super(coordinates, entityName, speed, healfPoint);
        
        this.coordinates = coordinates;
        this.entityName = entityName;
        this.speed = speed;
        this.healfPoint = healfPoint;
    }

    @Override
    protected void makeMove(Map map) {
        // Проверить на то что обект не выходит за грани каррты
        Set<Coordinates> speedSquares = map.getSpeedSquares(this.speed, this.coordinates);
        List<Coordinates> availableSquares = new LinkedList<>();
        boolean shifted = false;

        Herbivore newHerbivore = new Herbivore(this.coordinates, this.entityName, this.speed, this.healfPoint);
        for (Coordinates coordinates : speedSquares) {
            if(!(map.isSquareAvailableForEntity(coordinates, this.entityName))) continue;
                if(map.isEntityClose(this.coordinates, coordinates, EntityName.GRASS)) {
                    newHerbivore.healfPoint += 1;
                    map.eatEntity(coordinates, newHerbivore);
                    shifted = true;
                    break;
                } else {
                    shifted = false;
                    availableSquares.add(coordinates);
                }
            
        }

        if(!shifted){
            int randomInt = random.nextInt(availableSquares.size());
            Coordinates randomCoordinates = availableSquares.get(randomInt);
            newHerbivore.healfPoint -= 1;
            map.shiftEntity(randomCoordinates, newHerbivore);
        }
        // Проверить что клетка пустая для хода
        // Проверить есть ли рядом трава
        // Если трава рядом то приблизиться к не     // Если трава напротив то сесть ее
        // Если травы нет то паходи на пустую клетку
        
    }

  

    
    

   

 

}
