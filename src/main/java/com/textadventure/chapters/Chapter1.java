package com.textadventure.chapters;

import com.textadventure.characters.enemies.BasicMonsters;
import com.textadventure.characters.enemies.Skeleton;
import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.map.MapCreator;
import com.textadventure.status.GameState;
import com.textadventure.utils.GameLoop;

import java.util.HashMap;
import java.util.Map;

public class Chapter1 {
    private final GameState gs = GameState.getInstance();

    public void start() {

        String[][] customMap = {
                {"_", "1", "_", "_", "_", "b", "_", "!"},
                {"_", "1", "_", "a", "_", "b", "_", "c"},
                {"_", "1", "_", "a", "_", "b", "_", "c"},
                {"_", "1", "_", "a", "_", "b", "_", "c"},
                {"_", "1", "_", "a", "_", "b", "_", "c"},
                {"_", "1", "_", "a", "_", "b", "_", "c"},
                {"_", "1", "_", "a", "_", "b", "_", "c"},
                {"_", "_", "_", "a", "_", "_", "_", "c"},
                {"_", "_", "_", "a", "_", "_", "_", "c"}
        };

        gs.setMap(new MapCreator(customMap));
        gs.setPlayerPosition(new int[]{0, 0});


        // Create enemies and add to gameState
        Map<CharacterEntity, int[]> enemies = new HashMap<>();

        enemies.put(Skeleton.create("Skil"), new int[]{3, 0});
        enemies.put(Skeleton.create("Skel"), new int[]{4, 0});
        enemies.put(Skeleton.create("Skul"), new int[]{6, 0});
        enemies.put(Skeleton.create("Skol"), new int[]{5, 0});
        enemies.put(BasicMonsters.createBlob(), new int[]{2, 2});

        gs.setEnemiesWithPositions(enemies);

        // Game Loop
        GameLoop.run();

    }
}

