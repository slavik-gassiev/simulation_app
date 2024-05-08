package com.simulation.actions;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.entitys.Rock;
import com.simulation.entitys.Tree;
import com.simulation.map.Map;
public class ActionInit {
    Map map;
    public ActionInit(Map map) {
        this.map = map;
    }

    public void setDefaultEntitys() {
        map.setEntitys(new Coordinates(1, 2), new Rock(new Coordinates(1, 2), EntityName.ROCK));
        map.setEntitys(new Coordinates(2, 4), new Tree(new Coordinates(2, 4), EntityName.TREE));
        map.setEntitys(new Coordinates(3, 6), new Rock(new Coordinates(3, 6), EntityName.ROCK));
        map.setEntitys(new Coordinates(4, 3), new Rock(new Coordinates(4, 3), EntityName.ROCK));
        map.setEntitys(new Coordinates(6, 5), new Tree(new Coordinates(6, 5), EntityName.TREE));
        map.setEntitys(new Coordinates(8, 7), new Rock(new Coordinates(8, 7), EntityName.ROCK));
    }
}
