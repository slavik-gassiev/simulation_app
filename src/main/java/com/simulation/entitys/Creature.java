package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.CoordinatesShift;
import com.simulation.EntityName;
import com.simulation.Map;

public abstract class Creature extends Entity {

    public Integer speed;
    public Integer healfPoint;

    public Creature(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint) {
        super(coordinates, entityName);
        
        this.speed = speed;
        this.healfPoint = healfPoint;
    }

    protected abstract void makeMove(Map map);
      // Проверить на то что обект не выходит за грани каррты
        // Проверить что клетка пустая для хода
        // Проверить есть ли рядом трава
        // Если трава рядом то приблизиться к ней
        // Если трава напротив то сесть ее
        // Если травы нет то паходи на пустую клетку
}
