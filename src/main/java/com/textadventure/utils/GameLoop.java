package com.textadventure.utils;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.commands.handling.CommandInitializer;
import com.textadventure.status.GameState;

import java.util.ArrayList;
import java.util.List;
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
            GameState.getInstance().locatePlayer();
            System.out.print("Enter your command: ");
            playerInput = ScannerSingleton.getInstance().nextLine();
            CommandInitializer.getInstance().parseAndExecuteCommand(playerInput);
            GameState gs = GameState.getInstance();

            // TODO: refactor in another class
            if (!gs.getPlayer().isAlive()) {
                System.out.println("You died!");
            }
            List<CharacterEntity> deadEnemies = new ArrayList<>();
            List<CharacterEntity> aliveEnemies = gs.getEnemies();
            for (CharacterEntity enemy : gs.getEnemies()) {
                if (!enemy.isAlive()) {
                    System.out.println(enemy.getName() + " has died!");
                    deadEnemies.add(enemy);
                }
            }
            aliveEnemies.removeIf(deadEnemies::contains);
            gs.setEnemies(aliveEnemies);

        } while (!Objects.equals(playerInput, "stop"));
    }
}
