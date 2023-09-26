package com.textadventure.commands;

import com.textadventure.status.GameState;

public class Stop extends CommandEntity {

    public Stop(GameState gameState) {
        super(gameState);
    }

    public void execute(String... attributes) {
        System.out.println("Goodbye, Thank you for playing!");
    }

}
