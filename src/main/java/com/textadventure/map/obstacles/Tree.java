package com.textadventure.map.obstacles;

public class Tree extends ObstacleEntity {
    public Tree() {
        this.setSymbol('t');
        this.setName("Tree");
        this.setDescription("There is a tree there!");
        this.setIsPassable(Boolean.FALSE);
        this.setIsVisible(Boolean.TRUE);
    }

    @Override
    public void interact() {
        // No interactions for now
    }

}
