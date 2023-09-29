package com.textadventure.commands;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.characters.Player;
import com.textadventure.status.GameState;
import java.util.HashMap;
import java.util.Map;

public class Attack extends CommandEntity {

    private Player player;

    public Attack(GameState gameState) {
        super(gameState);
        player = gameState.getPlayer();
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
            // TODO
            player.attack(allEnemies.get(attribute[0]));
            System.out.println("Nemico esiste");
        } else {
            System.out.println("Invalid enemy");
        }
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }


}
