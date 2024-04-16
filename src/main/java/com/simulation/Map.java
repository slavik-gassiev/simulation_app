package com.simulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.simulation.entitys.*;

public class Map {
    public HashMap<Coordinates, Entity> entitys = new HashMap<Coordinates, Entity>();
   


    public void setEntitys(Coordinates coordinates, Entity entity) {
        if(Objects.equals(null, entity)) {
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
        
        setEntitys(to, entity);
        entitys.remove(from);
        
     }
 
     public void removeEnity(Coordinates coordinates) {
         entitys.remove(coordinates);
     }
 
 
     public void eatEntity(Coordinates from, Coordinates to) {
         // Coordinates from = entity.coordinates;
         
         shift(from, to);
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

        // setEntitys(new Coordinates(1, 1), new Rock(new Coordinates(1, 1), EntityName.ROCK));
        // setEntitys(new Coordinates(2, 1), new Tree(new Coordinates(2, 1), EntityName.TREE));
        // setEntitys(new Coordinates(3, 1), new Rock(new Coordinates(3, 1), EntityName.ROCK));

        // setEntitys(new Coordinates(1, 4), new Rock(new Coordinates(1, 1), EntityName.ROCK));
        // setEntitys(new Coordinates(2, 4), new Tree(new Coordinates(2, 1), EntityName.TREE));
        // setEntitys(new Coordinates(3, 4), new Rock(new Coordinates(3, 1), EntityName.ROCK));


        // setEntitys(new Coordinates(1, 8), new Rock(new Coordinates(1, 1), EntityName.ROCK));
        // setEntitys(new Coordinates(2, 8), new Tree(new Coordinates(2, 1), EntityName.TREE));
        // setEntitys(new Coordinates(3, 8), new Grass(new Coordinates(3, 8), EntityName.GRASS));

        setEntitys(new Coordinates(6, 6), new Herbivore(new Coordinates(6, 6),  EntityName.HERBIVORE, 1, 2));

        // setEntitys(new Coordinates(7, 7), new Herbivore(new Coordinates(7, 7),  EntityName.HERBIVORE, 1, 2));

        
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

    public boolean isSquareAvailableForEntity(Coordinates coordinates, EntityName entityName) {
        if(!(isSquareInMapAvailable(coordinates))){
            return false;
        }
        
        if (isSquareEmpty(coordinates)){
            return true;
        }
        
        if (isSquareHasEntity(coordinates, entityName)) {
            return true;
        }
        
        return false;
    }
    




    public boolean isSquareHasEntity(Coordinates coordinates, EntityName entityName) {

        if(isSquareEmpty(coordinates)) {
            return false;
        }
    
        Entity entity = getEntity(coordinates);
        
        if(Objects.equals(entity.entityName, entityName)) {
             return true;
        }

        return false;

        }
        
        public boolean isEntityClose(Coordinates sourceCoordinates, Coordinates checkingCoordinates, EntityName entityName) {
            if(!(isSquareHasEntity(checkingCoordinates, entityName))){
                return false;
            }
            if(isSquareClose(sourceCoordinates, checkingCoordinates)){
                return true;
            }
            
            return false;
           
    }

    public boolean isSquareClose(Coordinates sourceCoordinates, Coordinates checkingCoordinates) {

        if(isSquareEmpty(checkingCoordinates)) {
            return false;
        }

        Set<Coordinates> closeCoordinates = new HashSet<>();
        for (int lon = -1; lon < 2; lon++) {
            if(lon == 0) continue;
            Coordinates coordinates = new Coordinates(checkingCoordinates.longitude + lon, checkingCoordinates.latitude);
            closeCoordinates.add(coordinates);
        }

        for (int lat = -1; lat < 2; lat++) {
            if(lat == 0) continue;
            Coordinates coordinates = new Coordinates(checkingCoordinates.longitude, checkingCoordinates.latitude + lat);
            closeCoordinates.add(coordinates);
        }

        for (int lon = -1; lon < 2; lon++) {
            for (int lat = -1; lat < 2; lat++) {
                if(lat == 0 && lon == 0) continue;
                Coordinates coordinates = new Coordinates(checkingCoordinates.longitude + lon, checkingCoordinates.latitude + lat);
                closeCoordinates.add(coordinates);
            }
        }

        

        for (Coordinates coordinates : closeCoordinates) {
            if(!(isSquareInMapAvailable(coordinates))) continue;
            if(Objects.equals(coordinates, sourceCoordinates)) {
                return true;
            }
        }

        return false;

    }
    

    public boolean isEntityHPLow(Coordinates coordinates) {
        Entity entity = getEntity(coordinates);
        if(entity.healfPoint <= 0) {
            return true;
        }

        return false;
    }

   


        
       
    }

  









    



