package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.EntityName;

public abstract class Entity {
    public Coordinates coordinates;
    public final EntityName entityName;


    public Entity(Coordinates coordinates, EntityName entityName) {
        this.coordinates = coordinates;
        this.entityName = entityName;
    }

    public String getName() {
        String name = this.entityName.toString();
        return name;
    }
}
