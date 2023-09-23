package textadventure.map;
import textadventure.characters.Player;
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
        String mapContent = map[goToPos[0]][goToPos[1]];

        return Objects.equals(mapContent, "_");
    }

    public void filler() {
        int rows = map.length;
        int cols = map[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i == gameState.getPlayerPosition()[0] && j == gameState.getPlayerPosition()[1]) {
                    map[i][j] = "x";
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
