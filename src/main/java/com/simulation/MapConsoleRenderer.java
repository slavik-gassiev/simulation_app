package com.simulation;

import java.util.HashMap;

public class MapConsoleRenderer {
    public Map map;

    public MapConsoleRenderer (Map map) {
        this.map = map;
    }


    public void render() {
       HashMap<Coordinates, Entity> entitys = map.entitys;
        for (int lat = 0; lat < 8; lat++) {
            String stroke = "";
            for (int lon  = 0; lon < 8.; lon++) {
                Coordinates coordinates = new Coordinates(lon,lat);
                if(entitys.containsKey(coordinates)){
                    stroke += (" "+ getSquareForEntity(coordinates) + " ");
                } else {
                    stroke += getEmptySquare(coordinates);
                }
                
            }
            System.out.println(stroke);
        }
    }


    private String getEmptySquare(Coordinates coordinates) {
        String result = "  :: ";


        return result;
    }


    private String getSquareForEntity(Coordinates coordinates) {
        
        String entityName = map.entitys.get(coordinates).getName();
        String result = getEmojiForEntity(entityName);
        return result;
        
    }


    private String getEmojiForEntity(String entityName) {
        switch(entityName) {
            case "GRASS":
                return " G ";
            case "ROCK":
                return " R ";
            case "TREE":
                return " T ";
            case "HERBIVORE":
                return " H ";
            case "PREDATOR":
                return " P ";
            default:
                return " :: ";
        }
    }
}
