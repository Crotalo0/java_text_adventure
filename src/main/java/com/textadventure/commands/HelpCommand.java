package com.textadventure.commands;

import com.textadventure.status.GameState;

public class HelpCommand extends Command{

    public HelpCommand(GameState gameState) {
        super(gameState);
    }

    public void execute(String... attributes) {
        System.out.println("Help work in progress...");
    }

}
