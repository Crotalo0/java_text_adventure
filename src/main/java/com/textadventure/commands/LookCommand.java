package com.textadventure.commands;

import com.textadventure.status.GameState;

public class LookCommand extends Command{
    public LookCommand(GameState gameState) {
        super(gameState);
        attributes = new String[] {"north", "south", "east", "west"};
    }

    @Override
    public void execute(String... attribute) {
        if (isValidAttribute(attribute[0])) {
            System.out.println("You look towards " + attribute[0]);
        } else {
            System.out.println("Invalid direction");
        }
    }

}
