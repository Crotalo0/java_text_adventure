package com.textadventure.map;

import com.textadventure.map.entities.Obstacle;
import com.textadventure.status.GameState;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
public class GameMap {
    private final char[][] mapGrid;
    private Integer width;
    private Integer height;
    private Obstacle[][] obstacles;

    private List<Character> allCharObstacles = new ArrayList<>(
            Arrays.asList('t', 's')
    );

    private List<Character> obstacleList = new ArrayList<>();

    public GameMap(char[][] mapGrid) {
        this.mapGrid = mapGrid;
        this.width = mapGrid[0].length;
        this.height = mapGrid.length;
        this.obstacles = new Obstacle[height][width];
    }

    public void addObstacle(int x, int y, Obstacle obstacle) {
        if (x >= 0 && x < width && y >= 0 && y < height) {
            mapGrid[x][y] = obstacle.getSymbol();
            obstacles[x][y] = obstacle;
        }
    }

    public void checkForObstacles() {
        int rows = this.height;
        int cols = this.width;
        GameState gs = GameState.getInstance();
        for (int i = 0; i < rows; i++) {
            System.out.print("");
            for (int j = 0; j < cols; j++) {
                if (allCharObstacles.contains(mapGrid[i][j])) {
                    Obstacle obstacle  = Obstacle.createObstacle(mapGrid[i][j]);
                    gs.getMap().addObstacle(i,j, obstacle);
                }
            }
        }
    }

    public boolean isAccessible(int[] goToPos) {
        List<Character> possibleChars = new ArrayList<>();
        possibleChars.add('_');
        possibleChars.add('z');
        possibleChars.add('a');

        return possibleChars.contains(mapGrid[goToPos[0]][goToPos[1]]);
    }

    public void printer() {
        int rows = this.height;
        int cols = this.width;
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("");
            for (int j = 0; j < cols; j++) {
                System.out.printf("|_%s_", mapGrid[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }

    public void setCellValue(Character entity, int i, int j) {
        this.mapGrid[i][j] = entity;
    }
}