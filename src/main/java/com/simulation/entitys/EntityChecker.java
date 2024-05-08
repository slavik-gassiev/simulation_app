package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.map.Map;
import com.simulation.map.MapChecker;
import java.util.Objects;

public class EntityChecker {

    public static boolean isSquareAvailableForEntity(Coordinates coordinates, EntityName entityName) {
        if (!(MapChecker.isSquareInMapAvailable(coordinates))) {
            return false;
        }
        if (MapChecker.isSquareEmpty(coordinates)) {
            return true;
        }
        return isSquareHasEntity(coordinates, entityName);
    }

    public static boolean isSquareHasEntity(Coordinates coordinates, EntityName entityName) {
        if (MapChecker.isSquareEmpty(coordinates)) {
            return false;
        }
        Entity entity = Map.getEntity(coordinates);
        return Objects.equals(entity.entityName, entityName);

    }

    public static boolean isEntityClose(Coordinates sourceCoordinates, Coordinates checkingCoordinates, EntityName entityName) {
        if (!(isSquareHasEntity(checkingCoordinates, entityName))) {
            return false;
        }
        return MapChecker.isSquareClose(sourceCoordinates, checkingCoordinates);

    }

    public static boolean isEntityHPLow(Coordinates coordinates) {
        return Map.getEntity(coordinates).healfPoint <= 0;

    }

}
