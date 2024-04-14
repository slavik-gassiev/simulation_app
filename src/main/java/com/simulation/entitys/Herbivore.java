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
        Herbivore newHerbivore = new Herbivore(this.coordinates, this.entityName, this.speed, this.healfPoint);
        for (Coordinates coordinates : speedSquares) {
            if(!(map.isSquareAvailableForEntity(coordinates, this.entityName))) continue;
            if(map.isEntityClose(this.coordinates, coordinates, EntityName.GRASS)) {
                newHerbivore.healfPoint += 1;
                map.eatEntity(coordinates, newHerbivore);
            }
            newHerbivore.healfPoint -= 1;
            map.shiftEntity(coordinates, newHerbivore);
            
        }
        // Проверить что клетка пустая для хода
        // Проверить есть ли рядом трава
        // Если трава рядом то приблизиться к не     // Если трава напротив то сесть ее
        // Если травы нет то паходи на пустую клетку
        
    }

  

    
    

   

 

}
