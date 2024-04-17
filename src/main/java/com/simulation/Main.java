package com.simulation;
import com.simulation.entitys.*;


public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        MapConsoleRenderer renderer = new MapConsoleRenderer(map);
    
        Actions actions = new Actions(map);
        actions.initAction();
        renderer.render();
        System.out.println("--------------------");

        // actions.turnAction();
        // renderer.render();
        // System.out.println("--------------------");
        
        // Entity entity = map.entitys.get(new Coordinates(4, 7));

        for (int i = 0; i < 1; i++) {
            actions.turnAction();
            renderer.render();
            System.out.println("--------------------");
        }
        
        // int x = 3;
    }
}
