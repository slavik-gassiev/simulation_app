package com.simulation.actions;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.entitys.EntityChecker;
import com.simulation.entitys.Grass;
import com.simulation.entitys.Herbivore;
import com.simulation.entitys.Predator;
import com.simulation.entitys.moves.BasicHerbivoreMove;
import com.simulation.entitys.moves.BasicPredatoreMove;
import com.simulation.map.Map;
import com.simulation.map.MapChecker;

import java.util.HashMap;

public class ActionCreate {
    public static final int HOW_MANY_ENTITY_CREATE = 3;
    Map map;


    public ActionCreate(Map map) {
        this.map = map;


    }

    public void creatSmallEntity(HashMap<EntityName, EntityCount> entitysCounter) {
        for (EntityCount entityCount : entitysCounter.values()) {
            if ((entityCount.count >= HOW_MANY_ENTITY_CREATE)) continue;
            Coordinates coordinates = MapChecker.getRandomCoordinates();
            switch (entityCount.entityName) {
                case GRASS:
                    Map.getEntitys().put(coordinates, new Grass(coordinates, EntityName.GRASS));
                    break;
                case HERBIVORE:
                    Map.getEntitys().put(coordinates,
                            new Herbivore(coordinates, EntityName.HERBIVORE, 1, 1,
                                    new BasicHerbivoreMove()));
                    break;
                case PREDATOR:
                    Map.getEntitys().put(coordinates,
                            new Predator(coordinates, EntityName.PREDATOR, 1, 1, 1,
                                    new BasicPredatoreMove()));
                    break;
                default:
                    break;
            }

        }
    }
}
