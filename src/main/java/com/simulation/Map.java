package com.simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.simulation.entitys.*;

public class Map {
    public HashMap<Coordinates, Entity> entitys = new HashMap<Coordinates, Entity>();


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

    public boolean isSquareInMapAvailable(Coordinates coordinates) {
        if((coordinates.longitude > 8 || coordinates.latitude > 8) 
        || (coordinates.longitude < 1 || coordinates.latitude < 1)){
            return false;
        }
        return true;
    }



    public Set<Coordinates> getSpeedSquares(Integer speed, Coordinates coordinates) {
        Set<Coordinates> result = new HashSet<>();
        for (int lon = -speed; lon < speed; lon++) {
            for (int lat = -speed; lat < speed; lat++) {
                if(lon == 0 && lat == 0) continue;
                Coordinates newCoordinates = new Coordinates(coordinates.longitude + lon, coordinates.latitude + lat);
                if(!(isSquareInMapAvailable(newCoordinates))) continue;
                result.add(newCoordinates);
            }
        }

        return result;
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        if(!(entitys.containsKey(coordinates))){
            return true;
        } 

        return false;
    }

    public boolean isSquareAvailableForHervivore(Coordinates coordinates) {
        if(!(isSquareInMapAvailable(coordinates))){
            return false;
        }

       if (isSquareEmpty(coordinates)){
            return true;
       }

       if (isSquareHasGrass(coordinates)) {
            return true;
       }

       return false;
    }

    public boolean isSquareHasGrass(Coordinates coordinates) {
    
        Entity entity = entitys.get(coordinates);
        if(entity.entityName == EntityName.GRASS) {
             return true;
        }

        return false;

        }

    public boolean isGrassClose(Coordinates sourceCoordinates, Coordinates checkingCoordinates) {
        if(!(isSquareHasGrass(checkingCoordinates))){
            return false;
        }
        if(isSquareClose(sourceCoordinates, checkingCoordinates)){
           return true;
        }

        return false;
    }

    private boolean isSquareClose(Coordinates sourceCoordinates, Coordinates checkingCoordinates) {

        if(isSquareEmpty(checkingCoordinates)) {
            return false;
        }

        Set<Coordinates> closeCoordinates = new HashSet<>();
        for (int lon = -1; lon < 1; lon++) {
            if(lon == 0) continue;
            Coordinates coordinates = new Coordinates(checkingCoordinates.longitude + lon, checkingCoordinates.latitude);
            closeCoordinates.add(coordinates);
        }

        for (int lat = -1; lat < 1; lat++) {
            if(lat == 0) continue;
            Coordinates coordinates = new Coordinates(checkingCoordinates.longitude, checkingCoordinates.latitude + lat);
            closeCoordinates.add(coordinates);
        }

        for (Coordinates coordinates : closeCoordinates) {
            if(coordinates == sourceCoordinates) {
                return true;
            }
        }

        return false;

    }

    public void eatGrass(Coordinates from, Coordinates to, Integer healfPoint) {
        Entity herbivore = new Herbivore(to, EntityName.HERBIVORE, 3, healfPoint++);
        shift(from, to, herbivore);
    }

    private void shift(Coordinates from, Coordinates to, Entity entity) {
        entitys.remove(from);
        setEntitys(to, entity);
    }


        
    }







    



