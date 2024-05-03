package com.simulation;

import com.simulation.entitys.Entity;
import com.simulation.entitys.Herbivore;
import com.simulation.entitys.Rock;
import com.simulation.entitys.Tree;

import java.util.*;

public class Map {
    private final Random random = new Random();
    public HashMap<Coordinates, Entity> entitys = new HashMap<Coordinates, Entity>();
    int eatedGrass;
    int eatedHerbivore;

    public void setEntitys(Coordinates coordinates, Entity entity) {
        if (Objects.equals(null, entity)) {
            System.out.println("entity is null");
        } else {
            entity.coordinates = coordinates;
            entitys.put(coordinates, entity);

        }

    }

    public Entity getEntity(Coordinates coordinates) {
        return entitys.get(coordinates);
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
        //    entity.healfPoint -= hitStrength;
        //    shiftEntity(coordinates, entity);
    }

    public void setDefaultEntitys() {

        setEntitys(new Coordinates(1, 2), new Rock(new Coordinates(1, 2), EntityName.ROCK));
        setEntitys(new Coordinates(2, 4), new Tree(new Coordinates(2, 4), EntityName.TREE));
        setEntitys(new Coordinates(3, 6), new Rock(new Coordinates(3, 6), EntityName.ROCK));

        setEntitys(new Coordinates(4, 3), new Rock(new Coordinates(4, 3), EntityName.ROCK));
        setEntitys(new Coordinates(6, 5), new Tree(new Coordinates(6, 5), EntityName.TREE));
        setEntitys(new Coordinates(8, 7), new Rock(new Coordinates(8, 7), EntityName.ROCK));


//        setEntitys(new Coordinates(6, 6), new Herbivore(new Coordinates(6, 6), EntityName.HERBIVORE, 1, 2));

//        setEntitys(new Coordinates(7, 7), new Herbivore(new Coordinates(7, 7), EntityName.HERBIVORE, 1, 2));


    }

    public boolean isSquareInMapAvailable(Coordinates coordinates) {
        return (coordinates.longitude <= 8 && coordinates.latitude <= 8)
                && (coordinates.longitude >= 1 && coordinates.latitude >= 1);
    }

    public Set<Coordinates> getSpeedSquares(Integer speed, Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();
        for (int lon = -speed; lon <= speed; lon++) {
            for (int lat = -speed; lat < speed; lat++) {
                if (lon == 0 && lat == 0) continue;
                Coordinates newCoordinates = new Coordinates(coordinates.longitude + lon, coordinates.latitude + lat);
                if (!(isSquareInMapAvailable(newCoordinates))) continue;
                result.add(newCoordinates);
            }
        }

        return result;
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !(entitys.containsKey(coordinates));
    }

    public boolean isSquareAvailableForEntity(Coordinates coordinates, EntityName entityName) {
        if (!(isSquareInMapAvailable(coordinates))) {
            return false;
        }

        if (isSquareEmpty(coordinates)) {
            return true;
        }

        return isSquareHasEntity(coordinates, entityName);
    }


    public boolean isSquareHasEntity(Coordinates coordinates, EntityName entityName) {

        if (isSquareEmpty(coordinates)) {
            return false;
        }

        Entity entity = getEntity(coordinates);

        return Objects.equals(entity.entityName, entityName);

    }

    public boolean isEntityClose(Coordinates sourceCoordinates, Coordinates checkingCoordinates, EntityName entityName) {
        if (!(isSquareHasEntity(checkingCoordinates, entityName))) {
            return false;
        }
        return isSquareClose(sourceCoordinates, checkingCoordinates);

    }

    public boolean isSquareClose(Coordinates sourceCoordinates, Coordinates checkingCoordinates) {

        if (isSquareEmpty(checkingCoordinates)) {
            return false;
        }

        Set<Coordinates> closeCoordinates = new HashSet<>();
        for (int lon = -1; lon < 2; lon++) {
            if (lon == 0) continue;
            Coordinates coordinates = new Coordinates(checkingCoordinates.longitude + lon, checkingCoordinates.latitude);
            closeCoordinates.add(coordinates);
        }

        for (int lat = -1; lat < 2; lat++) {
            if (lat == 0) continue;
            Coordinates coordinates = new Coordinates(checkingCoordinates.longitude, checkingCoordinates.latitude + lat);
            closeCoordinates.add(coordinates);
        }

        for (int lon = -1; lon < 2; lon++) {
            for (int lat = -1; lat < 2; lat++) {
                if (lat == 0 && lon == 0) continue;
                Coordinates coordinates = new Coordinates(checkingCoordinates.longitude + lon, checkingCoordinates.latitude + lat);
                closeCoordinates.add(coordinates);
            }
        }


        for (Coordinates coordinates : closeCoordinates) {
            if (!(isSquareInMapAvailable(coordinates))) continue;
            if (Objects.equals(coordinates, sourceCoordinates)) {
                return true;
            }
        }

        return false;

    }


    public boolean isEntityHPLow(Coordinates coordinates) {
        Entity entity = getEntity(coordinates);
        return entity.healfPoint <= 0;
    }


    public Coordinates getRandomCoordinates() {

        Coordinates randomCoordinates;
        while (true) {
            randomCoordinates = new Coordinates(random.nextInt(8), random.nextInt(8));
            if (((randomCoordinates.longitude < 1) || (randomCoordinates.latitude < 1))) continue;
            if (!(isSquareEmpty(randomCoordinates))) continue;

            return randomCoordinates;
        }


    }


}

  









    



