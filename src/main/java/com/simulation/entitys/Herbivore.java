package com.simulation.entitys;


import com.simulation.Coordinates;
import com.simulation.EntityName;
import com.simulation.map.Map;
import com.simulation.entitys.moves.HerbivoreMoves;
import com.simulation.map.MapChecker;
import java.util.Random;

public class Herbivore extends Creature {
    MapChecker mapChecker = new MapChecker();
    Random random = new Random();
    HerbivoreMoves herbivoreMoves;

    public Herbivore(Coordinates coordinates, EntityName entityName, Integer speed, Integer healfPoint, HerbivoreMoves herbivoreMoves) {
        super(coordinates, entityName, speed, healfPoint);
        this.herbivoreMoves = herbivoreMoves;
    }

    @Override
    public void makeMove(Map map) {
        herbivoreMoves.move(map, coordinates, entityName, speed, healfPoint);
    }

}
