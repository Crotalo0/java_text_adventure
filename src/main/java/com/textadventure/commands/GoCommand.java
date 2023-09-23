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
    public void execute(String attribute) {
        if (isValidAttribute(attribute)) {
            System.out.println("You go " + attribute + ".");
            // Command logic
            // Get map bounds and player position
            int[] currPos = gameState.getPlayerPosition();
            int[] mapDimension = gameState.getMapDimension();

            int rowPos = currPos[0], colPos = currPos[1];

            // TODO Add checks for boundaries
            switch (attribute) {
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
            }
            gameState.moveTo(new int[] {rowPos,colPos});


            // move one square every go command in desired direction


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