package com.textadventure.utils;

import com.textadventure.commands.handling.CommandInitializer;
import com.textadventure.status.DeathCheck;
import com.textadventure.status.GameState;

import java.util.Objects;

public class GameLoop {

    private GameLoop() {
        throw new IllegalStateException("Utility Class");
    }

    public static void run() {
        clearConsole();
        System.out.println("Benvenuto nelle terre del cazzo!");
        String playerInput;
        ScannerSingleton.getInstance().nextLine();
        do {

            System.out.println("For now you are here");
            GameState.getInstance().locateCharacters();
            System.out.print("Enter your command: ");
            playerInput = ScannerSingleton.getInstance().nextLine();
            clearConsole();
            System.out.println("Last input: " + playerInput);
            CommandInitializer.getInstance().parseAndExecuteCommand(playerInput);
            DeathCheck.handleDeadEnemies(GameState.getInstance());

        } while (!Objects.equals(playerInput, "stop") && !DeathCheck.isPlayerDead());
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
