package com.simulation.entitys;

import java.util.HashMap;
import java.util.Objects;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.Map;

public class Actions {

    

    Map map;
    public Actions(Map map) {
        this.map = map;
    }

     

    public void initAction() {
        map.setDefaultEntitys();
        
        
    }

    public void turnAction() {
        HashMap<Coordinates, Entity> newEntitys = new HashMap<>();
        newEntitys = map.entitys;
       for (Coordinates coordinates : newEntitys.keySet()) {
        // map.entitys.get(coordinates).makeMove(map);
        Entity entity = newEntitys.get(coordinates);
        if(!((entity.entityName == EntityName.HERBIVORE) || (entity.entityName == EntityName.PREDATOR))) continue;
        System.out.println(coordinates.longitude + " " + coordinates.latitude);
        map.entitys.get(coordinates).makeMove(map);
        break;
       }

    //     map.entitys.get(new Coordinates(4, 7)).makeMove(map);
    //    int x = 3;
    }

    
}
