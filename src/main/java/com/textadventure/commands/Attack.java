package com.textadventure.commands;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.characters.Player;
import com.textadventure.commands.entities.CommandEntity;
import com.textadventure.status.GameState;
import java.util.HashMap;
import java.util.Map;

public class Attack extends CommandEntity {


    public Attack(GameState gameState) {
        super(gameState);
    }

    public Map<String, CharacterEntity> enemyToString() {
        HashMap<String, CharacterEntity> attributes = new HashMap<>();
        for (CharacterEntity e : gameState.getEnemies()) {
            attributes.put(e.getName().toLowerCase(), e);
        }
        return attributes;
    }

    @Override
    public void execute(String... attribute) {
        // convert all active enemies to strings for attributes
        Map<String, CharacterEntity> allEnemies = enemyToString();
        this.attributes = allEnemies.keySet().toArray(new String[0]);

        if (isValidAttribute(attribute[0])) {
            Player.getInstance().attack(allEnemies.get(attribute[0]));
        } else {
            System.out.println("Invalid enemy");
        }
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
