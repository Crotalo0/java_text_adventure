package com.textadventure.map;

import java.util.Objects;

public class MapCreator {
    private String[][] mapArray;
    private Integer x;
    private Integer y;

    public MapCreator(String[][] mapArray) {
        this.mapArray = mapArray;
        this.x = mapArray[0].length;
        this.y = mapArray.length;
    }

    // TODO: better logic. "_" should become an array of accessible values
    public boolean isAccessible(int[] goToPos) {
        return Objects.equals(mapArray[goToPos[0]][goToPos[1]], "_");
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

    public String[][] getMapArray() {
        return mapArray;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }
}