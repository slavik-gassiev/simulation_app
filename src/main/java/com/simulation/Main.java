package com.simulation;
import com.simulation.entitys.*;


public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.setDefaultEntitys();
        MapConsoleRenderer renderer = new MapConsoleRenderer(map);
        renderer.render();
        boolean x = map.isGrassClose(new Coordinates(4, 7), new Coordinates(3, 8));
        // boolean x = map.isSquareClose(new Coordinates(4, 7), new Coordinates(4, 8));
        System.out.println(x);
        // renderer.render();
        
        
      
    }
}
