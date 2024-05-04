package com.simulation.map;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.entitys.Entity;

import java.util.HashMap;
import java.util.Objects;

public class Map {

    private static HashMap<Coordinates, Entity> entitys = new HashMap<Coordinates, Entity>();
    public int eatedGrass;
    public int eatedHerbivore;

    public void setEntitys(Coordinates coordinates, Entity entity) {
        if (Objects.equals(null, entity)) {
            System.out.println("entity is null");
        } else {
            entity.coordinates = coordinates;
            entitys.put(coordinates, entity);

        }

    }

    public static Entity getEntity(Coordinates coordinates) {
        return entitys.get(coordinates);
    }

    public static HashMap<Coordinates, Entity> getEntitys() {
        return entitys;
    }

    public void shift(Coordinates from, Coordinates to) {
        Entity entity = getEntity(from);

        removeEnity(to);
        entitys.remove(from);
        setEntitys(to, entity);


    }

    public void removeEnity(Coordinates coordinates) {
        entitys.remove(coordinates);
    }


    public void eatEntity(Coordinates from, Coordinates to) {

        getCountOfEatedEntitys(to);


        shift(from, to);
    }

    private void getCountOfEatedEntitys(Coordinates to) {
        if (entitys.get(to).entityName == EntityName.GRASS) {
            eatedGrass += 1;
        }

        if (entitys.get(to).entityName == EntityName.HERBIVORE) {
            eatedHerbivore += 1;
        }
    }

    public void shiftEntity(Coordinates from, Coordinates to) {

        shift(from, to);
    }

    public void hitEntity(Coordinates coordinates, Integer hitStrength) {
        getEntity(coordinates).healfPoint -= hitStrength;

    }

    public boolean isEntityHPLow(Coordinates coordinates) {
        Entity entity = getEntity(coordinates);
        return entity.healfPoint <= 0;
    }


}

  









    



