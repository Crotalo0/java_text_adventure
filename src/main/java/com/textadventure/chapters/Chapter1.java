package com.textadventure.chapters;

import com.textadventure.entities.Player;
import com.textadventure.entities.Skeleton;
import com.textadventure.map.MapCreator;
import com.textadventure.status.GameState;

public class Chapter1 {
    private Player player;

    public Chapter1(Player player) {
        this.player = player;
    }

    public void start() {
        GameState gameState = new GameState();
        MapCreator map = new MapCreator(3,3, gameState);
        Skeleton skeleton = new Skeleton();
        map.filler();
        map.printer();
        player.printStats();
        skeleton.printStats();

        gameState.setPlayerPosition(new int[] {0,0});
        int[] posTestInit = gameState.getPlayerPosition();
        System.out.printf("Initial position -- x: %d, y: %d%n",posTestInit[0], posTestInit[1]);

        player.moveTo(new int[] {0,1}, map, gameState);
        int[] posTest = gameState.getPlayerPosition();
        System.out.printf("After position -- x: %d, y: %d%n",posTest[0], posTest[1]);
        System.out.println("Position on the map:");
        map.filler();
        map.printer();



    }

}
