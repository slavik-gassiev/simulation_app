package com.simulation;

import java.util.HashMap;

import com.simulation.entitys.*;

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

        setEntitys(new Coordinates(1, 4), new Rock(new Coordinates(1, 1), EntityName.ROCK));
        setEntitys(new Coordinates(2, 4), new Rock(new Coordinates(2, 1), EntityName.TREE));
        setEntitys(new Coordinates(3, 4), new Rock(new Coordinates(3, 1), EntityName.ROCK));


        setEntitys(new Coordinates(1, 8), new Rock(new Coordinates(1, 1), EntityName.ROCK));
        setEntitys(new Coordinates(2, 8), new Rock(new Coordinates(2, 1), EntityName.TREE));
        setEntitys(new Coordinates(3, 8), new Rock(new Coordinates(3, 1), EntityName.ROCK));

        setEntitys(new Coordinates(4, 7), new Herbivore(new Coordinates(4, 7),  EntityName.HERBIVORE, 2, 2));
        
        
    }


    public static boolean canShift(Coordinates coordinates, CoordinatesShift coordinatesShift) {
       if (!((coordinates.longitude += coordinatesShift.lonShift) > 8
        && (coordinates.latitude += coordinatesShift.latShift) > 8)) {
            return true;
       } else {
            return false;
       }
    }

}

    



