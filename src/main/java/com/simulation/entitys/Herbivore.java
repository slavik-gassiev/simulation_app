package com.simulation.entitys;


import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.Map;
import com.simulation.entitys.moves.BasicHerbivoreMove;
import com.simulation.entitys.moves.HerbivoreMoves;
import com.simulation.entitys.moves.PredatoreMoves;

import java.util.Random;


public class Herbivore extends Creature {


    Random random = new Random();
    HerbivoreMoves herbivoreMoves = new BasicHerbivoreMove();

    public Herbivore(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint) {
        super(coordinates, entityName, speed, healfPoint);

    }

    public void setMove(PredatoreMoves predatoreMoves) {
        this.herbivoreMoves = herbivoreMoves;
    }

    @Override
    public void makeMove(Map map) {
        herbivoreMoves.move(map, coordinates, entityName, speed, healfPoint);
    }

}
