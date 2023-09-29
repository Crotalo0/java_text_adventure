package com.textadventure.commands;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.characters.Player;
import com.textadventure.status.GameState;
import java.util.Map;

public class SuperAttack extends Attack {

    private Player player;
    public SuperAttack(GameState gameState) {
        super(gameState);
        player = gameState.getPlayer();
    }

    @Override
    public void execute(String... attribute) {
        // convert all active enemies to strings for attributes
        Map<String, CharacterEntity> allEnemies = enemyToString();
        this.attributes = allEnemies.keySet().toArray(new String[0]);

        if (isValidAttribute(attribute[0])) {
            // TODO
            player.superAttack(allEnemies.get(attribute[0]));
        } else {
            System.out.println("Invalid enemy");
        }
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }
}
