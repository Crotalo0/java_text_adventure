package com.textadventure.commands;

import com.textadventure.status.GameState;

public abstract class Command {

    protected GameState gameState;
    protected String[] attributes;

    public Command(GameState gameState) {
        this.gameState = gameState;
    }

    public void execute(String attribute) {
        if (isValidAttribute(attribute)) {
            System.out.println("You look towards " + attribute);
        } else {
            System.out.println("Invalid direction");
        }
    }
    public boolean isValidAttribute(String direction) {
        for (String element : attributes) {
            if (element.equalsIgnoreCase(direction)) return true;
        }
        return false;
    }
}

