package com.simulation;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.setDefaultEntitys();
        MapConsoleRenderer renderer = new MapConsoleRenderer(map);
        renderer.render();
        
      
    }
}
