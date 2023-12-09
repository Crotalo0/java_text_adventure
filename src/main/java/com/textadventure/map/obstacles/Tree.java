package com.textadventure.map.obstacles;

import com.textadventure.map.entities.Obstacle;

public class Tree extends Obstacle {
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
