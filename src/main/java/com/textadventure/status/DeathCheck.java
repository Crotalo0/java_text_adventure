package com.textadventure.status;

import com.textadventure.characters.Player;
import com.textadventure.characters.entities.CharacterEntity;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeathCheck {

    private DeathCheck() {
        throw new IllegalStateException("Utility Class");
    }

    public static boolean isPlayerDead() {
        GameState gameState = GameState.getInstance();
        Player player = gameState.getPlayer();

        if (player.isDead()) {
            System.out.println("You died!");
            return true;
        }
        return false;
    }

    public static void handleDeadEnemies(GameState gameState) {
        Set<CharacterEntity> deadEnemies = new HashSet<>();

        for (CharacterEntity enemy : gameState.getEnemiesWithPositions().keySet()) {
            if (enemy.isDead()) {
                System.out.println(enemy.getName() + " has died!");
                int[] enemyPos = gameState.getEnemiesWithPositions().get(enemy);
                gameState.getMap().setCellValue('_', enemyPos[0], enemyPos[1]);
                deadEnemies.add(enemy);
            }
        }
        removeDeadEnemiesFromMap(deadEnemies, gameState);
    }

    private static void removeDeadEnemiesFromMap(Set<CharacterEntity> deadEnemies, GameState gameState) {
        Map<CharacterEntity, int[]> aliveEnemiesMap = gameState.getEnemiesWithPositions();

        for (CharacterEntity enemy : deadEnemies) {
            aliveEnemiesMap.remove(enemy);
        }
        gameState.setEnemiesWithPositions(aliveEnemiesMap);
    }
}
