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
        };

        // gameState contains all info on position of player, enemies and map
        gs.setMap(new MapCreator(customMap));
        gs.setPlayerPosition(new int[]{0, 1});



        // Create enemies and add to gameState
        Map<CharacterEntity, Integer[]> enemies = new HashMap<>();

        enemies.put(Skeleton.create("Skil"), new Integer[] {0,2});
        enemies.put(Skeleton.create("Skel"), new Integer[] {0,3});
        enemies.put(Skeleton.create("Skol"), new Integer[] {0,4});
        enemies.put(Skeleton.create("Skul"), new Integer[] {0,5});
        enemies.put(BasicMonsters.createBlob(), new Integer[] {2,2});

        gs.setEnemiesWithPositions(enemies);

        // Game Loop
        GameLoop.run();

    }
}

