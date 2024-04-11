package com.simulation;

import java.util.HashMap;

public class Map {
    HashMap<Coordinates, Entity> entitys = new HashMap<Coordinates, Entity>();


    public void setEntitys(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        entitys.put(coordinates, entity);
    }

    public void setDefaultEntitys() {
        setEntitys(new Coordinates(1, 1), new Rock(new Coordinates(1, 1), EntityName.ROCK));
        setEntitys(new Coordinates(2, 1), new Rock(new Coordinates(2, 1), EntityName.TREE));
        setEntitys(new Coordinates(3, 1), new Rock(new Coordinates(3, 1), EntityName.ROCK));
        
    }
}
