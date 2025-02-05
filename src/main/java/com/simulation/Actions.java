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
    

    private void setEntityCount() {
        entitysCounter.put(EntityName.GRASS, new EntityCount(EntityName.GRASS, 0));
        entitysCounter.put(EntityName.HERBIVORE, new EntityCount(EntityName.HERBIVORE, 0));
        entitysCounter.put(EntityName.PREDATOR, new EntityCount(EntityName.PREDATOR, 0));
    }

    private Map map;

    public Actions(Map map) {
        this.map = map;
    }

     

    public void initAction() {
        map.setDefaultEntitys();
        
        
    }

    public void turnAction() {
        setEntityCount();
        countEntitys();
        creatSmalEntity();
        makeMoveAllEntitys();
        
        
        
       
 
        }



  



  



 



    private void creatSmalEntity() {
        for (EntityCount entityCount : entitysCounter.values()) {
            if((entityCount.count >= 2)) continue;
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

        

        int grassCounter = entitysCounter.get(EntityName.GRASS).count;
        int herbivoreCounter =  entitysCounter.get(EntityName.HERBIVORE).count;
        int predatorCounter =  entitysCounter.get(EntityName.PREDATOR).count;

        

        for (Entity entity  : map.entitys.values()) {
            EntityName name = entity.entityName;
            
            switch (name) {
                case GRASS:
                    grassCounter += 1;
                    entitysCounter.get(name).count = grassCounter;
                    break;
                case HERBIVORE:
                    herbivoreCounter += 1;
                    entitysCounter.get(name).count = herbivoreCounter;
                    break;
                case PREDATOR:
                    predatorCounter += 1;
                    entitysCounter.get(name).count = predatorCounter;
                    break;
                default:
                    break;

                
            }

     
            
        }

        

       
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




    


