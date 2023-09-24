package com.textadventure.commands;

import com.textadventure.status.GameState;

public class StopCommand extends Command{

    public StopCommand(GameState gameState) {
        super(gameState);
    }

    public void execute(String... attributes) {
        System.out.println("Goodbye");
    }

}
