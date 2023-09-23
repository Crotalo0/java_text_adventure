package com.textadventure.status;

import com.textadventure.entities.Player;
import com.textadventure.map.MapCreator;

public class GameState {

    private MapCreator map;
    private Player player;

    public MapCreator getMap() {
        return map;
    }
    public void setMap(MapCreator map) {
        this.map = map;
    }
    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }

    // playerPosition[0] -> coord X
    // playerPosition[1] -> coord Y
    private int[] playerPosition = new int[2]; // [0,1]
    private int[] mapDimension;

    // Getter and setter
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
