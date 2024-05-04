package com.simulation.Actions;


import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.Map;
import com.simulation.entitys.Entity;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ActionTurn {

    private final Map map;


    public ActionTurn(Map map) {
        this.map = map;
    }


    public void makeMoveAllEntity() {
        List<Coordinates> newEntitys = new LinkedList<>();

        for (Entity entity : map.entitys.values()) {

            if (!(Objects.equals(entity.entityName, EntityName.HERBIVORE) ||
                    Objects.equals(entity.entityName, EntityName.PREDATOR) ||
                    Objects.equals(entity, null))) continue;
            newEntitys.add(entity.coordinates);


        }

        for (Coordinates coordinates : newEntitys) {
            int lon = coordinates.longitude;
            int lat = coordinates.latitude;

            map.entitys.get(new Coordinates(lon, lat)).makeMove(map);


        }
    }
}




    


