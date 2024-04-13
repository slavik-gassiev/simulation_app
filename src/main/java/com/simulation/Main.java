package com.simulation;
import com.simulation.entitys.*;


public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.setDefaultEntitys();
        MapConsoleRenderer renderer = new MapConsoleRenderer(map);
        renderer.render();
        
        
      
    }
}
