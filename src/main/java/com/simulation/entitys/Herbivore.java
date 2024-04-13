package com.simulation.entitys;

import java.util.Set;

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
    protected void makeMove(Map map) {
        // Проверить на то что обект не выходит за грани каррты
        Set<Coordinates> speedSquares = map.getSpeedSquares(this.speed, this.coordinates);
        for (Coordinates coordinates : speedSquares) {
            if(!(map.isSquareAvailableForHervivore(coordinates))) continue;
            if(map.isSquareHasGrass(coordinates)) {
                map.shift(this.coordinates, coordinates);
            }
            
        }
        // Проверить что клетка пустая для хода
        // Проверить есть ли рядом трава
        // Если трава рядом то приблизиться к ней
        // Если трава напротив то сесть ее
        // Если травы нет то паходи на пустую клетку
        
    }

  

    
    

   

 

}
