package com.textadventure.status;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.characters.Player;
import com.textadventure.map.MapCreator;

import java.util.LinkedList;
import java.util.List;

public class GameState {

    private MapCreator map;
    private final Player player;
    private List<CharacterEntity> enemies = new LinkedList<>();
    private int[] playerPosition = new int[2];

    public GameState() {
        this.player = Player.getInstance();
    }

    //TODO: Enemy positions
    public void mapFiller() {
        // Fills the map with player, enemies and various entities (for now only player)
        int rows = map.getX();
        int cols = map.getY();
        int[] playerPos = getPlayerPosition();
        boolean playerFound = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == playerPos[0] && j == playerPos[1] && !playerFound) {
                    map.setMapArray("x", i, j);
                    playerFound = true;
                } else {
                    map.setMapArray("_", i, j);
                }
            }
        }
        mapPrinter();
    }

    public void moveTo(int[] goToPos) {
        int rows = map.getX();
        int cols = map.getY();

        if (goToPos[0] > rows) {
            System.out.println("Cant go out map");
        }
        if (goToPos[1] > cols) {
            System.out.println("Cant go out map");
        }
        if (map.isAccessible(goToPos)) {
            setPlayerPosition(goToPos);
        } else {
            System.out.println("Not a valid destination");
        }

    }

    public void mapPrinter() {map.printer();}
    public int[] getMapDimension() {
        return new int[] {map.getX(), map.getY()};
    }
    public MapCreator getMap() {
        return map;
    }
    public void setMap(MapCreator map) {
        this.map = map;
    }
    public Player getPlayer() {
        return player;
    }
    public int[] getPlayerPosition() {
        return playerPosition;
    }
    public void setPlayerPosition(int[] playerPosition) {
        this.playerPosition = playerPosition;
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

    public void createEnemy(CharacterEntity s) {
        setEnemy(s);
    }


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
