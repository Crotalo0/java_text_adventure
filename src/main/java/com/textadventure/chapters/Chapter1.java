package com.textadventure.chapters;

import com.textadventure.characters.CharacterEntity;
import com.textadventure.commands.*;
import com.textadventure.characters.Player;
import com.textadventure.characters.Skeleton;
import com.textadventure.map.MapCreator;
import com.textadventure.status.GameState;
import com.textadventure.utils.InputParser;
import com.textadventure.utils.ParsedInput;
import com.textadventure.weapons.DefensiveWeapon;
import com.textadventure.weapons.OffensiveWeapon;
import com.textadventure.weapons.WeaponEntity;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Chapter1 {
    private final Player player;
    private final Scanner s;
    public Chapter1(Player player, Scanner scanner) {
        this.player = player;
        this.s = scanner;
    }

    public void start() {
        // gameState contains all info on position of player and enemies and map
        GameState gameState = new GameState();
        gameState.setPlayer(player);
        gameState.setMap(new MapCreator(4,4));

        CommandProcessor commandProcessor = new CommandInitializer(gameState);

        // Create enemies and add to gameState
        CharacterEntity skel = new Skeleton("skel");
        gameState.setEnemy(skel);

        CharacterEntity  skol = new Skeleton("skol");
        gameState.setEnemy(skol);

        CharacterEntity  skul = new Skeleton("skul");
        gameState.setEnemy(skul);

        // Set player weapon
        System.out.println("Choose your combat style:\n1.Aggressive 2.Defensive");
        int chosenCombat = s.nextInt();
        WeaponEntity startingWeapon = (chosenCombat == 1) ?  new OffensiveWeapon() : new DefensiveWeapon();

        // Equip weapon
        player.setWeapon(startingWeapon);

        // Set player starting position
        gameState.setPlayerPosition(new int[] {0,0});

        // TEST USER INPUT
        String[] validCommands = commandProcessor.getCommands().keySet().toArray(new String[0]);
        InputParser inputParser = new InputParser(validCommands);

        // Game Loop
        String playerInput;
        s.nextLine();
        do {
            System.out.println("For now you are here");
            gameState.mapFiller();

            System.out.print("Enter your command: ");

            playerInput = s.nextLine();
            ParsedInput parsedInput = inputParser.parseInput(playerInput);

            String command = parsedInput.getCommand();
            List<String> arguments = List.of(parsedInput.getArguments());
            commandProcessor.executeCommand(command, arguments);

        } while(!Objects.equals(playerInput, "stop"));
    }
}

