package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.map.Map;

public abstract class Entity {
    public Coordinates coordinates;
    public EntityName entityName;
    public Integer healfPoint = 1;

    public Entity(Coordinates coordinates, EntityName entityName) {
        this.coordinates = coordinates;
        this.entityName = entityName;
    }

    public String getName() {
      return this.entityName.toString();
    }

    public abstract void makeMove(Map map);
}
