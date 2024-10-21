package com.textadventure.status;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.characters.Player;
import com.textadventure.map.GameMap;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
public class GameState {
    private static GameState instance;
    private final Player player = Player.getInstance();
    private GameMap map;
    private Character tileUnderPlayer = '_';
    private Map<CharacterEntity, int[]> enemiesWithPositions = new HashMap<>();
    private int[] playerPosition = new int[2];

    public static GameState getInstance() {
        if (null == instance) {
            instance = new GameState();
        }
        return instance;
    }

    public void initializeChapter(char[][] customMap, int[] playerPos, Map<CharacterEntity, int[]> enemies) {
        this.setMap(new GameMap(customMap));
        this.setPlayerPosition(playerPos);
        this.setEnemiesWithPositions(enemies);
        map.checkForObstacles();
    }

    public void locateCharacters() {
        // Fills the map with player, enemies and various entities
        for (Map.Entry<CharacterEntity, int[]> enemy : enemiesWithPositions.entrySet()) {
            int[] enemyPos = enemy.getValue();
            map.setCellValue('z', enemyPos[0], enemyPos[1]);
        }
        int[] playerPos = getPlayerPosition();
        map.setCellValue('x', playerPos[0], playerPos[1]);
        mapPrinter();
    }

    public void moveTo(int[] goToPos) {
        // 1. get current player position
        // 2. replaces it with the element that was in the node under the player
        // 3. overwrites tileUnderPlayer with the contents of the destination node
        // 4. moves the player over that node
        int[] currentPlayerPos = this.getPlayerPosition();
        map.setCellValue(tileUnderPlayer, currentPlayerPos[0], currentPlayerPos[1]);
        tileUnderPlayer = map.getMapGrid()[goToPos[0]][goToPos[1]];
        setPlayerPosition(goToPos);
    }

    public void mapPrinter() {
        map.printer();
    }

    public int[] getMapDimension() {
        return new int[]{map.getWidth(), map.getHeight()};
    }

    public Set<CharacterEntity> getEnemies() {
        return enemiesWithPositions.keySet();
    }

    public CharacterEntity findEnemyByName(String name) {
        for (CharacterEntity enemy : enemiesWithPositions.keySet()) {
            if (enemy.getName().toLowerCase().equals(name)) {
                return enemy;
            }
        }
        return null;
    }


}
