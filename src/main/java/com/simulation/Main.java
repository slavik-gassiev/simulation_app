package com.simulation;

public class Main {
    public static void main(String[] args) {
        Map map = new Map();
        map.setDefaultEntitys();
        for (Entity entity : map.entitys.values()) {
            System.out.println(entity.entityName);
        }
      
    }
}
