package com.textadventure.commands;

import com.textadventure.status.GameState;

public class StatusCommand extends Command {


    public StatusCommand(GameState gameState) {
        super(gameState);
        attributes = new String[]{"player"};
    }
    @Override
    public void execute(String... attribute) {
        gameState.getPlayer().printStats();
    }
}
