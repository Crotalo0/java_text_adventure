package com.textadventure.commands;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.status.GameState;

public class Look extends CommandEntity {
    public Look() {
        attributes = new String[]{"enemies"};
    }

    @Override
    public void execute(String... attribute) {
        if (isValidAttribute(attribute[0])) {
            System.out.println("You look towards " + attribute[0]);

            for (CharacterEntity enemy : GameState.getInstance().getEnemies()) {
                System.out.println("name: " + enemy.getName() + ", hp: " + enemy.getHp());
            }
        } else {
            System.out.println("Invalid attribute");
        }
    }

}
