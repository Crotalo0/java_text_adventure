package com.textadventure.utils;

import com.textadventure.commands.handling.CommandInitializer;
import com.textadventure.status.GameState;

import java.util.Objects;

public class GameLoop {

    private GameLoop() {
        throw new IllegalStateException("Utility Class");
    }

    public static void run() {
        boolean isPlayerDead = false;
        String playerInput;
        ScannerSingleton.getInstance().nextLine();
        do {
            System.out.println("For now you are here");
            GameState.getInstance().locateCharacters();
            System.out.print("Enter your command: ");
            playerInput = ScannerSingleton.getInstance().nextLine();
            CommandInitializer.getInstance().parseAndExecuteCommand(playerInput);
            isPlayerDead = GameState.isPlayerDead();


        } while (!Objects.equals(playerInput, "stop") && !isPlayerDead);
    }
}
