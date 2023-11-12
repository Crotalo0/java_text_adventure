package com.textadventure.commands;

import com.textadventure.commands.entities.CommandEntity;
import com.textadventure.status.GameState;

public class Go extends CommandEntity {
    private GameState gs = GameState.getInstance();

    public Go() {
        attributes = new String[]{"north", "south", "east", "west", "up", "down", "right", "left"};
    }
    @Override
    public void execute(String... attribute) {
        if (isValidAttribute(attribute[0])) {
            int[] currPos = gs.getPlayerPosition();
            int[] mapDimension = gs.getMapDimension();

            int rowPos = currPos[0];
            int colPos = currPos[1];

            switch (attribute[0]) {
                case "north", "up" -> rowPos -= 1;  // (Objects.equals(attribute[0], "north"))
                case "south", "down" -> rowPos += 1;
                case "east", "right" -> colPos += 1;
                case "west", "left" -> colPos -= 1;
            }

            if (rowPos < mapDimension[0] && colPos < mapDimension[1] && rowPos >= 0 && colPos >= 0 ) {
                gs.moveTo(new int[]{rowPos, colPos});
                System.out.println("You go " + attribute[0] + ".");
            } else {
                System.out.println("There is a wall there!");
            }

        } else {
            System.out.println("Invalid direction");
        }
    }
}