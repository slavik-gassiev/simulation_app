package com.simulation.entitys;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.Map;

public class Actions {

    


    private Map map;

    public Actions(Map map) {
        this.map = map;
    }

     

    public void initAction() {
        map.setDefaultEntitys();
        
        
    }

    public void turnAction() {
            List<Coordinates> newEntitys = new LinkedList<>();
            

            for (Entity entity : map.entitys.values()) {
                if(!(Objects.equals(entity.entityName, EntityName.HERBIVORE) || 
                Objects.equals(entity.entityName, EntityName.PREDATOR) ||
                Objects.equals(entity, null))) continue;
                newEntitys.add(entity.coordinates);
                
              
            }


            for (Coordinates coordinates : newEntitys) {
                
                map.getEntity(coordinates).makeMove(map);     
              
            }

           
        }
    }




    


