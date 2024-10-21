package com.textadventure.map.obstacles;

import lombok.Data;

@Data
public abstract class ObstacleEntity {

    private char symbol;
    private int[] pos;
    private String name;
    private String description;
    private Boolean isPassable;
    private Boolean isVisible;

    public static ObstacleEntity createObstacle(char type) {
        return switch (type) {
            case 't' -> new Tree();
            case 's' -> new Stone();
            default -> throw new IllegalArgumentException("Invalid obstacle type: " + type);
        };
    }

    public abstract void interact();
}
