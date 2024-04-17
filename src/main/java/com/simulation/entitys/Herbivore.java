package com.simulation.entitys;


import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Random;

import com.simulation.Coordinates;

import com.simulation.EntityName;
import com.simulation.Map;


public class Herbivore extends Creature {

    // public Coordinates coordinates;
    // EntityName entityName;
    // Integer speed;
    // Integer healfPoint;

    Random random = new Random();

    public Herbivore(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint) {
        super(coordinates, entityName, speed, healfPoint);
        
        // this.coordinates = coordinates;
        // this.entityName = entityName;
        // this.speed = speed;
        // this.healfPoint = healfPoint;
    }

    @Override
    public void makeMove(Map map) {
        // Проверить на то что обект не выходит за грани каррты
        Set<Coordinates> speedSquares = map.getSpeedSquares(this.speed, this.coordinates);
        List<Coordinates> availableSquares = new LinkedList<>();
        boolean shifted = false;

        // Herbivore newHerbivore = new Herbivore(this.coordinates, this.entityName, this.speed, this.healfPoint);
        for (Coordinates speedCoordinates : speedSquares) {
            if(!(map.isSquareAvailableForEntity(speedCoordinates, EntityName.GRASS))) continue;
                if(map.isEntityClose(this.coordinates, speedCoordinates, EntityName.GRASS)) {
                    // newHerbivore.healfPoint += 1;
                    map.eatEntity(this.coordinates, speedCoordinates);
                    shifted = true;
                    break;
                } else {
                    shifted = false;
                    availableSquares.add(speedCoordinates);
                }
            
        }

        if(!shifted){
            int randomInt = random.nextInt(availableSquares.size());
            Coordinates randomCoordinates = availableSquares.get(randomInt);
            // newHerbivore.healfPoint -= 1;
            // Coordinates ssCoordinates = this.coordinates;
            map.shiftEntity(this.coordinates, randomCoordinates);
            
            int x = 3;
        }
        // Проверить что клетка пустая для хода
        // Проверить есть ли рядом трава
        // Если трава рядом то приблизиться к не     // Если трава напротив то сесть ее
        // Если травы нет то паходи на пустую клетку
        
    }

  

    
    

   

 

}
