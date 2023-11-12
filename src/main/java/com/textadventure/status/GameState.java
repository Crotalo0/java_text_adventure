package com.textadventure.status;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.characters.Player;
import com.textadventure.map.MapCreator;

import java.util.LinkedList;
import java.util.List;

public class GameState {

    private static GameState instance;
    private MapCreator map;
    private Player player;
    private List<CharacterEntity> enemies = new LinkedList<>();
    private int[] playerPosition = new int[2]; // [0,1]
    private int[] mapDimension;

    public GameState() {
        this.player = Player.getInstance();
    }

    // Global point of access to the singleton instance
    public static GameState getInstance() {
        if (instance == null) {
            instance = new GameState();
        }
        return instance;
    }

    public MapCreator getMap() {
        return map;
    }
    public void setMap(MapCreator map) {
        this.map = map;
    }
    public int[] getPlayerPosition() {
        return playerPosition;
    }
    public void setPlayerPosition(int[] playerPosition) {
        this.playerPosition = playerPosition;
    }
    public int[] getMapDimension() {
        return mapDimension;
    }
    public void setMapDimension(int[] mapDimension) {
        this.mapDimension = mapDimension;
    }


    public void moveTo(int[] goToPos) {
        // Get map dimension
        int rows = map.getMap().length;
        int cols = map.getMap()[0].length;

        // Check if player wants to go out of the map
        if (goToPos[0] > rows) {
            System.out.println("Cant go out map");
        }
        if (goToPos[1] > cols) {
            System.out.println("Cant go out map");
        }

        if (map.isAccessible(goToPos)) {
            // go to that cube
            setPlayerPosition(goToPos);
        } else {
            System.out.println("Not a valid destination");
        }

    }

    public List<CharacterEntity> getEnemies() {
        return enemies;
    }

    public void setEnemies(List<CharacterEntity> enemies) {
        this.enemies = enemies;
    }

    public void setEnemy(CharacterEntity enemy) {
        this.getEnemies().add(enemy);
    }

    public CharacterEntity getPlayer() {
        return this.player;
    }

    //TODO : Implement death there!


    // int[][]
    //     0   1
    // 0 |_!_|___|
    // 1 |___|___|
    // After .setPlayerPosition([1,1])
    //     0   1
    // 0 |___|___|
    // 1 |___|_!_|


    // 0 |_2a_|___|_1_|_1_|
    // 1 |___|___|___|_1_|
    // 2 |_1_|___|___|_1_|
    // 3 |_1_|_1_|___|_2b_|

    // 0 |_2b_|___|_1_|_1_|
    // 1 |___|___|___|_1_|
    // 2 |_1_|___|___|_1_|
    // 3 |_1_|_1_|___|_2c_|

}
