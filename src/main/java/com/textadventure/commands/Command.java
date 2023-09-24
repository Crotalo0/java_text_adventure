package com.textadventure.commands;

import com.textadventure.status.GameState;

public abstract class Command {

    protected GameState gameState;
    protected String[] attributes;

    public Command(GameState gameState) {
        this.gameState = gameState;
    }

    public abstract void execute(String... attribute);

    public boolean isValidAttribute(String direction) {
        for (String element : attributes) {
            if (element.equalsIgnoreCase(direction)) return true;
        }
        return false;
    }
}

