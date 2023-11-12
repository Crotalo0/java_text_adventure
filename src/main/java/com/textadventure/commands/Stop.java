package com.textadventure.commands;

import com.textadventure.commands.entities.CommandEntity;
import com.textadventure.status.GameState;

public class Stop extends CommandEntity {

    public Stop() {
    }

    public void execute(String... attributes) {
        System.out.println("Goodbye, Thank you for playing!");
    }

}
