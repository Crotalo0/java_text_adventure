package com.textadventure.status;

import com.textadventure.characters.Player;
import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.map.MapCreator;

import java.util.LinkedList;
import java.util.List;

public class GameState {

    String[][] customMap = {
            {"_", "|", "_", "_", "_", "b", "_", "!"},
            {"_", "|", "_", "a", "_", "b", "_", "c"},
            {"_", "|", "_", "a", "_", "b", "_", "c"},
            {"_", "|", "_", "a", "_", "b", "_", "c"},
            {"_", "|", "_", "a", "_", "b", "_", "c"},
            {"_", "|", "_", "a", "_", "b", "_", "c"},
            {"_", "|", "_", "a", "_", "b", "_", "c"},
            {"_", "_", "_", "a", "_", "_", "_", "c"},
    };

    // Pattern singleton
    private static GameState instance;
    private final Player player;
    private MapCreator map;
    private String tileUnderPlayer = "_";
    private List<CharacterEntity> enemies = new LinkedList<>();
    private int[] playerPosition = new int[2];

    public GameState() {
        this.player = Player.getInstance();
    }

    public static GameState getInstance() {
        if (null == instance) {
            instance = new GameState();
        }
        return instance;
    }

    public void mapInitializer() {
        // Initialize map with nothing in
        int rows = map.getX();
        int cols = map.getY();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map.setMapArray("_", i, j);
            }
        }
    }

    //TODO: Enemy positions
    public void locatePlayer() {
        // Fills the map with player, enemies and various entities (for now only player)
        int[] playerPos = getPlayerPosition();
        map.setMapArray("x", playerPos[0], playerPos[1]);
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
            // 1. get current player position
            // 2. replaces it with the element that was in the node under the player
            // 3. overwrites tileUnderPlayer with the contents of the destination node
            // 4. moves the player over that node
            int[] currentPlayerPos = this.getPlayerPosition(); // [x, y]
            map.setMapArray(tileUnderPlayer, currentPlayerPos[0], currentPlayerPos[1]);
            tileUnderPlayer = map.getMapArray()[goToPos[0]][goToPos[1]];
            setPlayerPosition(goToPos);
        } else {
            // TODO: add flavours, like trees etc...
            System.out.println("Not an accessible destination");
        }
    }

    public void mapPrinter() {
        map.printer();
    }

    public int[] getMapDimension() {
        return new int[]{map.getX(), map.getY()};
    }

    public MapCreator getMap() {
        return map;
    }

    public void setMap(MapCreator map) {
        this.map = map;
        // mapInitializer();
        map.setMapArray(customMap);
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

    public void insertEnemies(CharacterEntity... enemies) {
        for (CharacterEntity enemy : enemies)
            setEnemy(enemy);
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
