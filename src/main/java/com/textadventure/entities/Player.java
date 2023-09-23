package com.textadventure.entities;

import com.textadventure.map.MapCreator;
import com.textadventure.status.GameState;

public class Player extends CharactersEntity{

    public Player(String name) {
        this.setName(name);
        this.setMaxHp(100);
        this.setHp(100);
        this.setDmg(10);
    }

    public void printStats() {
        System.out.printf("I am %s and i have %d/%d hp and i have %d damage!%n",
                this.getName(), this.getHp(), this.getMaxHp(), this.getDmg());
    }

    public void moveTo(int[] goToPos, MapCreator mapObj, GameState gameState) {
        // Get map dimension
        int rows = mapObj.getMap().length;
        int cols = mapObj.getMap()[0].length;

        // Check if player wants to go out of the map
        if (goToPos[0] > rows) {
            System.out.println("Cant go out map");
        }
        if (goToPos[1] > cols) {
            System.out.println("Cant go out map");
        }

        if (mapObj.isAccessible(goToPos)) {
            // go to that cube
            gameState.setPlayerPosition(goToPos);
        } else {
            System.out.println("Not a valid destination");
        }


    }
}
