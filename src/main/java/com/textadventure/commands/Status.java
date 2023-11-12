package com.textadventure.commands;

import com.textadventure.characters.Player;
import com.textadventure.commands.entities.CommandEntity;
import com.textadventure.status.GameState;

public class Status extends CommandEntity {


    public Status(GameState gameState) {
        super(gameState);
        attributes = new String[]{"player"};
    }
    @Override
    public void execute(String... attribute) {
        Player.getInstance().printStats();
    }
}
