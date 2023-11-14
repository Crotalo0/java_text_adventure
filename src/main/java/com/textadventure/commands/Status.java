package com.textadventure.commands;

import com.textadventure.characters.Player;
import com.textadventure.commands.entities.CommandEntity;

public class Status extends CommandEntity {


    public Status() {
        attributes = new String[]{"player"};
    }
    @Override
    public void execute(String... attribute) {
        Player.getInstance().printStats();
    }
}
