package com.simulation.actions;
import com.simulation.EntityName;
import com.simulation.entitys.Entity;
import com.simulation.map.Map;
import java.util.HashMap;

public class ActionChecker {
    private HashMap<EntityName, EntityCount> entitysCounter = new HashMap<>();
    public ActionChecker() {
        setEntityCount();
    }
    private void setEntityCount() {
        entitysCounter.put(EntityName.GRASS, new EntityCount(EntityName.GRASS, 0));
        entitysCounter.put(EntityName.HERBIVORE, new EntityCount(EntityName.HERBIVORE, 0));
        entitysCounter.put(EntityName.PREDATOR, new EntityCount(EntityName.PREDATOR, 0));
    }
    public HashMap<EntityName, EntityCount> countEntitys() {
        int grassCounter = entitysCounter.get(EntityName.GRASS).count;
        int herbivoreCounter = entitysCounter.get(EntityName.HERBIVORE).count;
        int predatorCounter = entitysCounter.get(EntityName.PREDATOR).count;

        for (Entity entity : Map.getEntitys().values()) {
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
        return entitysCounter;
    }
}
