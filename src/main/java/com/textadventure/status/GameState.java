package com.textadventure.status;

import com.textadventure.characters.Player;
import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.map.MapCreator;

import java.util.*;

public class GameState {

    // Pattern singleton
    private static GameState instance;
    private final Player player = Player.getInstance();
    private MapCreator map;
    private String tileUnderPlayer = "_";

    // { Enemy : [x,y]}
    private Map<CharacterEntity, Integer[]> enemiesWithPositions = new HashMap<>();

    private int[] playerPosition = new int[2];

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
                map.setCellValue("_", i, j);
            }
        }
    }

    public static boolean isPlayerDead() {
        GameState gs = GameState.getInstance();
        if (!gs.getPlayer().isAlive()) {
            System.out.println("You died!");
            return true;
        }

        Set<CharacterEntity> deadEnemies = new HashSet<>();
        Map<CharacterEntity, Integer[]> aliveEnemiesMap = gs.getEnemiesWithPositions();

        for (CharacterEntity enemy : gs.getEnemies()) {
            if (!enemy.isAlive()) {
                System.out.println(enemy.getName() + " has died!");
                Integer[] enemyPos = new Integer[] {aliveEnemiesMap.get(enemy)[1], aliveEnemiesMap.get(enemy)[0]};
                gs.getMap().setCellValue("_", enemyPos[0], enemyPos[1]);
                deadEnemies.add(enemy);
            }
        }
        // Remove the enemies in deadEnemies from the Main map
        for (CharacterEntity enemy : deadEnemies) {
            aliveEnemiesMap.remove(enemy);
        }
        gs.setEnemiesWithPositions(aliveEnemiesMap);
        return false;
    }

    public void locateCharacters() {
        // Fills the map with player, enemies and various entities
        int[] playerPos = getPlayerPosition();
        map.setCellValue("x", playerPos[1], playerPos[0]);

        for (Map.Entry<CharacterEntity, Integer[]> enemy : enemiesWithPositions.entrySet()) {
            Integer[] enemyPos = enemy.getValue();
            map.setCellValue("s", enemyPos[1], enemyPos[0]);
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
            // 1. get current player position
            // 2. replaces it with the element that was in the node under the player
            // 3. overwrites tileUnderPlayer with the contents of the destination node
            // 4. moves the player over that node
            int[] currentPlayerPos = this.getPlayerPosition(); // [x, y]
            map.setCellValue(tileUnderPlayer, currentPlayerPos[0], currentPlayerPos[1]);
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

    public Map<CharacterEntity, Integer[]> getEnemiesWithPositions() {
        return enemiesWithPositions;
    }
    public void setEnemiesWithPositions(Map<CharacterEntity, Integer[]> enemiesWithPositions) {
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
