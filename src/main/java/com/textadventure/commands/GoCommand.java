package com.textadventure.commands;

import com.textadventure.entities.Player;
import com.textadventure.status.GameState;

public class GoCommand extends Command {

    private Player player;

    public GoCommand(GameState gameState) {
        super(gameState);
        attributes = new String[] {"north", "south", "east", "west"};
    }

    @Override
    public void execute(String... attribute) {
        if (isValidAttribute(attribute[0])) {
            // Command logic
            // Get map bounds and player position
            int[] currPos = gameState.getPlayerPosition();
            int[] mapDimension = gameState.getMapDimension();

            int rowPos = currPos[0];
            int colPos = currPos[1];

            switch (attribute[0]) {
                case "north":
                    rowPos -= 1;
                    break;
                case "south":
                    rowPos += 1;
                    break;
                case "east":
                    colPos += 1;
                    break;
                case "west":
                    colPos -= 1;
                    break;
                default:
                    break;
                }

            if (rowPos < mapDimension[0] && colPos < mapDimension[1] && rowPos >= 0 && colPos >= 0 ) {
                gameState.moveTo(new int[]{rowPos, colPos});
                System.out.println("You go " + attribute[0] + ".");
            } else {
                System.out.println("There is a wall there!");
            }

        } else {
            System.out.println("Invalid direction");
        }
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }


}