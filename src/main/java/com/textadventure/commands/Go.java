package com.textadventure.commands;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.commands.entities.CommandEntity;
import com.textadventure.status.GameState;

import java.util.Arrays;
import java.util.Map;

public class Go extends CommandEntity {
    private final GameState gameState = GameState.getInstance();

    public Go() {
        attributes = new String[]{"north", "south", "east", "west", "up", "down", "right", "left"};
    }


    @Override
    public void execute(String... attribute) {
        if (isValidAttribute(attribute[0])) {
            int[] currPos = gameState.getPlayerPosition();
            int rowPos = currPos[0];
            int colPos = currPos[1];

            switch (attribute[0]) {
                case "north", "up" -> rowPos -= 1;  // (Objects.equals(attribute[0], "north"))
                case "south", "down" -> rowPos += 1;
                case "east", "right" -> colPos += 1;
                case "west", "left" -> colPos -= 1;
            }

            if (isWithinBounds(rowPos, colPos) && gameState.getMap().isAccessible(new int[]{rowPos, colPos})) {
                gameState.moveTo(new int[]{rowPos, colPos});
                System.out.println("You go " + attribute[0] + ".");

                // Enemies
                Map<CharacterEntity, int[]> test =  gameState.getEnemiesWithPositions();

                if ( isIntArrayPresent(new int[]{rowPos,colPos}, test)) {
                    System.out.println("There is an enemy! Battle start");
                }

            } else {
                String message = gameState.getMap().getObstacles()[rowPos][colPos].getDescription();
                System.out.println(message);
            }

        } else {
            System.out.println("Invalid direction");
        }
    }

    private boolean isWithinBounds(int rowPos, int colPos) {
        int[] mapDimension = gameState.getMapDimension();
        return rowPos < mapDimension[0] && colPos < mapDimension[1] && rowPos >= 0 && colPos >= 0;
    }
    public static boolean isIntArrayPresent(int[] targetArray, Map<?, int[]> map) {
        for (int[] array : map.values()) {
            if (Arrays.equals(array, targetArray)) {
                return true;
            }
        }
        return false;
    }
}