package com.textadventure.status;

import com.textadventure.characters.Player;
import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.map.MapCreator;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameState {
    private static GameState instance;
    private final Player player = Player.getInstance();
    private MapCreator map;
    private String tileUnderPlayer = "_";
    private Map<CharacterEntity, int[]> enemiesWithPositions = new HashMap<>();
    private int[] playerPosition = new int[2];

    public static GameState getInstance() {
        if (null == instance) {
            instance = new GameState();
        }
        return instance;
    }


    public static boolean isPlayerDead() {
        GameState gameState = GameState.getInstance();
        Player player = gameState.getPlayer();

        if (!player.isAlive()) {
            System.out.println("You died!");
            return true;
        }
        handleDeadEnemies(gameState);
        return false;
    }

    private static void handleDeadEnemies(GameState gameState) {
        Set<CharacterEntity> deadEnemies = new HashSet<>();

        for (CharacterEntity enemy : gameState.getEnemiesWithPositions().keySet()) {
            if (!enemy.isAlive()) {
                System.out.println(enemy.getName() + " has died!");
                int[] enemyPos = gameState.getEnemiesWithPositions().get(enemy);
                gameState.getMap().setCellValue("_", enemyPos[1], enemyPos[0]);
                deadEnemies.add(enemy);
            }
        }
        removeDeadEnemiesFromMap(gameState, deadEnemies);
    }

    private static void removeDeadEnemiesFromMap(GameState gameState, Set<CharacterEntity> deadEnemies) {
        Map<CharacterEntity, int[]> aliveEnemiesMap = gameState.getEnemiesWithPositions();

        for (CharacterEntity enemy : deadEnemies) {
            aliveEnemiesMap.remove(enemy);
        }
        gameState.setEnemiesWithPositions(aliveEnemiesMap);
    }

    public void emptyMapDrawer() {
        // Initialize map with nothing in
        int rows = map.getX();
        int cols = map.getY();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map.setCellValue("_", i, j);
            }
        }
    }

    public void locateCharacters() {
        // Fills the map with player, enemies and various entities
        int[] playerPos = getPlayerPosition();
        map.setCellValue("x", playerPos[0], playerPos[1]);

        for (Map.Entry<CharacterEntity, int[]> enemy : enemiesWithPositions.entrySet()) {
            int[] enemyPos = enemy.getValue();
            map.setCellValue("s", enemyPos[0], enemyPos[1]);
        }
        mapPrinter();
    }

    public void moveTo(int[] goToPos) {
        // 1. get current player position
        // 2. replaces it with the element that was in the node under the player
        // 3. overwrites tileUnderPlayer with the contents of the destination node
        // 4. moves the player over that node
        int[] currentPlayerPos = this.getPlayerPosition();
        map.setCellValue(tileUnderPlayer, currentPlayerPos[0], currentPlayerPos[1]);
        tileUnderPlayer = map.getMapArray()[goToPos[0]][goToPos[1]];
        setPlayerPosition(goToPos);
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

    public Map<CharacterEntity, int[]> getEnemiesWithPositions() {
        return enemiesWithPositions;
    }

    public void setEnemiesWithPositions(Map<CharacterEntity, int[]> enemiesWithPositions) {
        this.enemiesWithPositions = enemiesWithPositions;
    }

    public Set<CharacterEntity> getEnemies() {
        return enemiesWithPositions.keySet();
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
