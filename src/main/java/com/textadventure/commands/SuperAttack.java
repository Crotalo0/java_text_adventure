package com.textadventure.commands;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.characters.Player;
import com.textadventure.status.GameState;
import java.util.Map;

public class SuperAttack extends Attack {

    public SuperAttack(GameState gameState) {
        super(gameState);
    }

    @Override
    public void execute(String... attribute) {
        // convert all active enemies to strings for attributes
        Map<String, CharacterEntity> allEnemies = enemyToString();
        this.attributes = allEnemies.keySet().toArray(new String[0]);

        if (isValidAttribute(attribute[0])) {
            Player.getInstance().superAttack(allEnemies.get(attribute[0]));
        } else {
            System.out.println("Invalid enemy");
        }
    }
}
