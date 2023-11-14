package com.textadventure.chapters;

import com.textadventure.characters.enemies.BasicMonsters;
import com.textadventure.characters.enemies.Skeleton;
import com.textadventure.map.MapCreator;
import com.textadventure.status.GameState;
import com.textadventure.utils.GameLoop;

public class Chapter1 {
    private final GameState gs = GameState.getInstance();

    public void start() {

        // gameState contains all info on position of player, enemies and map
        gs.setMap(new MapCreator(8, 8));
        gs.setPlayerPosition(new int[]{0, 0});

        // Create enemies and add to gameState
        gs.insertEnemies(
                Skeleton.create("skil"),
                Skeleton.create("skel"),
                Skeleton.create("skol"),
                Skeleton.create("skul"),
                BasicMonsters.createBlob()
        );

        // Game Loop
        GameLoop.run();

    }
}

