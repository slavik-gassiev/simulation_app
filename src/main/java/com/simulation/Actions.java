package com.simulation;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;


import com.simulation.entitys.Entity;
import com.simulation.entitys.EntityCount;
import com.simulation.entitys.Grass;
import com.simulation.entitys.Herbivore;
import com.simulation.entitys.Predator;

public class Actions {

    HashMap<EntityName, EntityCount> entitysCounter = new HashMap<>();


    private Map map;

    public Actions(Map map) {
        this.map = map;
    }

     

    public void initAction() {
        map.setDefaultEntitys();
        
        
    }

    public void turnAction() {


        makeMoveAllEntitys();
        countEntitys();
        creatSmalEntity();
        
       
 
        }



  



  



 



    private void creatSmalEntity() {
        for (EntityCount entityCount : entitysCounter.values()) {
            if(!(entityCount.count <= 2)) continue;
            Coordinates coordinates = map.getRandomCoordinates();
            switch (entityCount.entityName) {
                case GRASS:
                    map.entitys.put(coordinates, new Grass(coordinates, EntityName.GRASS));
                    break;
                case HERBIVORE:
                    map.entitys.put(coordinates, new Herbivore(coordinates, EntityName.HERBIVORE, 1, 1));
                case PREDATOR:
                map.entitys.put(coordinates, new Predator(coordinates, EntityName.PREDATOR, 1, 1, 1));

                default:
                    break;
            }
            
        }
    }



    private void countEntitys() {

        

        int grassCounter = 0;
        int herbivoreCounter = 0;
        int predatorCounter = 0;

        for (Entity entity  : map.entitys.values()) {
            EntityName name = entity.entityName;
            
            switch (name) {
                case GRASS:
                    grassCounter += 1;
                    break;
                case HERBIVORE:
                    herbivoreCounter += 1;
                    break;
                case PREDATOR:
                    predatorCounter += 1;
                    break;
                default:
                    break;

                
            }
        }

        entitysCounter.put(EntityName.GRASS, new EntityCount(EntityName.GRASS, grassCounter));
        entitysCounter.put(EntityName.HERBIVORE, new EntityCount(EntityName.HERBIVORE, herbivoreCounter));
        entitysCounter.put(EntityName.PREDATOR, new EntityCount(EntityName.PREDATOR, predatorCounter));

       
    }



    private void makeMoveAllEntitys() {
        List<Coordinates> newEntitys = new LinkedList<>();

        for (Entity entity : map.entitys.values()) {

            if(!(Objects.equals(entity.entityName, EntityName.HERBIVORE) || 
            Objects.equals(entity.entityName, EntityName.PREDATOR) ||
            Objects.equals(entity, null))) continue;
            newEntitys.add(entity.coordinates);
            
          
        }


        for (Coordinates coordinates : newEntitys) {
                
           
               int lon = coordinates.longitude;
               int lat = coordinates.latitude;
             
               map.entitys.get(new Coordinates(lon, lat)).makeMove(map);;

    
            }
    }
    }




    


