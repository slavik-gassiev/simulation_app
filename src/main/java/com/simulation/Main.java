package com.simulation;
import com.simulation.entitys.*;


public class Main {
    public static void main(String[] args) {

        Map map = new Map();
        MapConsoleRenderer renderer = new MapConsoleRenderer(map);
        int moveCount = 0;
    
        Actions actions = new Actions(map);
        actions.initAction();
        renderer.render();
        System.out.println("--------------------");

       while (moveCount < 10) {
            actions.turnAction();
            renderer.render();
            System.out.println("--------------------");
            moveCount += 1;
            System.out.println("Число ходов: " + moveCount + " Убитых дерьеве: " 
            + map.eatedGrass + " Убитых травоядных: " + map.eatedHerbivore);
       }

       
        
      
    }
}
