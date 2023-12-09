package com.textadventure.map.obstacles;

import com.textadventure.map.entities.Obstacle;

public class Stone extends Obstacle {
    public Stone() {
        this.setSymbol('s');
        this.setName("Stone");
        this.setDescription("There is a stone there!");
        this.setIsPassable(Boolean.FALSE);
        this.setIsVisible(Boolean.TRUE);
    }

    @Override
    public void interact() {
        // No interactions for now
    }

}
