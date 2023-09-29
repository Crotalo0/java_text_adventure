package com.textadventure.commands;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.status.GameState;

public class Look extends CommandEntity {
    public Look(GameState gameState) {
        super(gameState);
        attributes = new String[] {"enemies"};
    }

    @Override
    public void execute(String... attribute) {
        if (isValidAttribute(attribute[0])) {
            System.out.println("You look towards " + attribute[0]);

            for (CharacterEntity enemy: gameState.getEnemies()) {
                System.out.println(enemy.getName());
            }
        } else {
            System.out.println("Invalid attribute");
        }
    }

}
