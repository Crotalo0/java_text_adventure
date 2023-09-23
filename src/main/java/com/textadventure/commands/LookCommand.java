package com.textadventure.commands;

import com.textadventure.status.GameState;

public class LookCommand extends Command{
    public LookCommand(GameState gameState) {
        super(gameState);
        attributes = new String[] {"north", "south", "east", "west"};
    }

    public void execute(String attribute) {
        if (isValidAttribute(attribute)) {
            System.out.println("You look towards " + attribute);
        } else {
            System.out.println("Invalid direction");
        }
    }

}
