package com.simulation;

import com.simulation.actions.ActionChecker;
import com.simulation.actions.ActionCreate;
import com.simulation.actions.ActionInit;
import com.simulation.actions.ActionTurn;
import com.simulation.map.Map;

public class GameLoop {
    private static final int MAX_TURN = 10;
    private static final Map map = new Map();
    private static final MapConsoleRenderer renderer = new MapConsoleRenderer(map);
    private static int moveCount = 0;
    private static ActionInit actionInit = new ActionInit(map);
    private static ActionChecker actionChecker = new ActionChecker();
    private static ActionCreate actionCreate = new ActionCreate(map);
    private static ActionTurn actionTurn = new ActionTurn(map);

    public void startGame() {
        actionInit.setDefaultEntitys();
        renderer.render();
        System.out.println("--------------------");

        while (moveCount < MAX_TURN) {
            actionCreate.creatSmallEntity(actionChecker.countEntitys());
            actionTurn.makeMoveAllEntity();
            renderer.render();
            System.out.println("--------------------");
            moveCount += 1;
            System.out.println("Число ходов: " + moveCount + " Убитых дерьеве: "
                    + map.eatedGrass + " Убитых травоядных: " + map.eatedHerbivore);
        }
    }
}
