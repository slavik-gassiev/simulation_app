package com.simulation;
import com.simulation.entitys.*;


public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        MapConsoleRenderer renderer = new MapConsoleRenderer(map);
        renderer.render();
        System.out.println("--------------------");

        Actions actions = new Actions(map);
        actions.initAction();
        renderer.render();
        System.out.println("--------------------");

        actions.turnAction();
        renderer.render();
        System.out.println("--------------------");
        
        // Entity entity = map.entitys.get(new Coordinates(4, 7));

        // for (int i = 0; i < 3; i++) {
        //     entity.makeMove(map);
        //     renderer.render();
        //     System.out.println("--------------------");
        // }
        
        // int x = 3;
    }
}
