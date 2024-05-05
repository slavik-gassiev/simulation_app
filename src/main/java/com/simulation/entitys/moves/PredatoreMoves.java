package com.simulation.entitys.moves;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.map.Map;

public interface PredatoreMoves {
    public void move(Map map,
                     Coordinates coordinates,
                     EntityName entityName,
                     Integer speed,
                     Integer healfPoint,
                     Integer hitStrength);
}
