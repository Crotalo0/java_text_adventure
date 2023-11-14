package com.textadventure.utils;

import com.textadventure.commands.handling.CommandInitializer;
import com.textadventure.status.GameState;

import java.util.Objects;

public class GameLoop {

    private GameLoop() {
        throw new IllegalStateException("Utility Class");
    }

    public static void run() {
        String playerInput;
        ScannerSingleton.getInstance().nextLine();
        do {
            System.out.println("For now you are here");
            GameState.getInstance().mapFiller();
            System.out.print("Enter your command: ");
            playerInput = ScannerSingleton.getInstance().nextLine();
            CommandInitializer.getInstance().parseAndExecuteCommand(playerInput);

        } while (!Objects.equals(playerInput, "stop"));
    }
}
