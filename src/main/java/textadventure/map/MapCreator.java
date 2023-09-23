package textadventure.map;
import textadventure.status.GameState;

import java.util.Objects;

public class MapCreator {
    private final String[][] map;
    private GameState gameState;

    public MapCreator(int x, int y, GameState gameState) {
        this.map = new String[x][y];
        this.gameState = gameState;
    }

    public boolean isAccessible(int[] goToPos) {
        return Objects.equals(map[goToPos[0]][goToPos[1]], "_");
    }

    public void filler() {
        int rows = map.length;
        int cols = map[0].length;
        int[] playerPos = gameState.getPlayerPosition();
        boolean playerFound = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == playerPos[0] && j == playerPos[1] && !playerFound) {
                    map[i][j] = "x";
                    playerFound = true;
                } else {
                    map[i][j] = "_";
                }
            }
        }
    }

    public void printer() {

        int rows = map.length;
        int cols = map[0].length;

        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("");
            for (int j = 0; j < cols; j++) {
                System.out.printf("|_%s_", map[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public String[][] getMap() {
        return map;
    }
}

// |___|___|___|
// |___|___|_1_|
// |___|___|___|
