package com.textadventure.commands;

public class Stop extends CommandEntity {

    public void execute(String... attributes) {
        System.out.println("Game aborted.");
    }

}
