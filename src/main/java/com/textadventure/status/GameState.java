package com.textadventure.status;

public class GameState {
    // playerPosition[0] -> coord X
    // playerPosition[1] -> coord Y
    private int[] playerPosition = new int[2]; // [0,1]

    // Getter and setter
    public int[] getPlayerPosition() {
        return playerPosition;
    }
    public void setPlayerPosition(int[] playerPosition) {
        this.playerPosition = playerPosition;

    }
    // Other game state information and methods


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
