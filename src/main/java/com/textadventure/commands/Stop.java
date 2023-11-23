package com.textadventure.commands;

import com.textadventure.commands.entities.CommandEntity;

public class Stop extends CommandEntity {

    public void execute(String... attributes) {
        System.out.println("Game aborted.");
    }

}
