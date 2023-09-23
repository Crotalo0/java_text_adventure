package textadventure.map;

public class MapCreator {
    private final int[][] map;

    public MapCreator(int x, int y) {
        map = new int[x][y];
    }

    public boolean isAccessible(int[] goToPos) {
        int mapContent = map[goToPos[0]][goToPos[1]];

        return mapContent == 1;
    }

    public void filler() {
        int rows = map.length;
        int cols = map[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map[i][j] = 1;
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
                System.out.printf("|_%d_", map[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }

    }

    public int[][] getMap() {
        return map;
    }
}

// |___|___|___|
// |___|___|_1_|
// |___|___|___|
