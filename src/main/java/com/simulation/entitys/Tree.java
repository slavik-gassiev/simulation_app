package com.simulation.entitys;

import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.Map;

public class Tree extends Entity{
   
    public Tree(Coordinates coordinates, EntityName entityName){
        super(coordinates, entityName);
    }

    @Override
    public void makeMove(Map map) {
        System.out.println("Tree");
    }
}
