package com.textadventure.chapters;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.characters.enemies.BasicMonsters;
import com.textadventure.characters.enemies.Skeleton;
import com.textadventure.status.GameState;
import com.textadventure.utils.GameLoop;

import java.util.HashMap;
import java.util.Map;

public class Chapter1 {
    private final GameState gs = GameState.getInstance();

    public void start() {

        char[][] customMap = {
                {'_', 's', '_', '_', '_', 's', '_', '!'},
                {'_', 's', '_', 't', '_', 's', '_', 't'},
                {'_', 's', '_', 't', '_', 's', '_', 't'},
                {'_', 's', '_', 't', '_', 's', '_', 't'},
                {'_', 's', '_', 't', '_', 's', '_', 't'},
                {'_', 's', '_', 't', '_', 's', '_', 't'},
                {'_', 's', '_', 't', '_', 's', '_', 't'},
                {'_', '_', '_', 't', '_', '_', '_', 't'},
                {'_', '_', '_', 't', '_', '_', '_', 't'}
        };

        int[] playerPos = new int[]{1, 0};
        Map<CharacterEntity, int[]> enemies = new HashMap<>();
        enemies.put(Skeleton.create("Skil"), new int[]{3, 0});
        enemies.put(Skeleton.create("Skel"), new int[]{4, 0});
        enemies.put(Skeleton.create("Skul"), new int[]{6, 0});
        enemies.put(Skeleton.create("Skol"), new int[]{5, 0});
        enemies.put(BasicMonsters.createBlob(), new int[]{2, 2});
        enemies.put(BasicMonsters.createZombie(), new int[]{1, 2});

        gs.initializeChapter(customMap, playerPos, enemies);
        GameLoop.run();
    }
}

