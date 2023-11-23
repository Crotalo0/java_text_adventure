package com.textadventure.map;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter @Setter
public class MapCreator {
    private final String[][] mapArray;
    private Integer x;
    private Integer y;

    public MapCreator(String[][] mapArray) {
        this.mapArray = mapArray;
        this.x = mapArray.length;
        this.y = mapArray[0].length;
    }

    public boolean isAccessible(int[] goToPos) {
        List<String> possibleChars = new ArrayList<>();
        possibleChars.add("_");
        possibleChars.add("s");
        possibleChars.add("a");

        return possibleChars.contains(mapArray[goToPos[0]][goToPos[1]]);
    }

    public void printer() {
        int rows = this.x;
        int cols = this.y;
        System.out.println();
        for (int i = 0; i < rows; i++) {
            System.out.print("");
            for (int j = 0; j < cols; j++) {
                System.out.printf("|_%s_", mapArray[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }
    public void setCellValue(String entity, int i, int j) {
        this.mapArray[i][j] = entity;
    }
}