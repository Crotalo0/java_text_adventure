package com.textadventure.map.obstacles;

public class Stone extends ObstacleEntity {
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
