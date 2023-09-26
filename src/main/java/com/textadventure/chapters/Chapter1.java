package com.textadventure.chapters;

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
    private Player player;

    public Chapter1(Player player) {
        this.player = player;
    }

    public void start() {

        Scanner s = new Scanner(System.in);
        GameState gameState = new GameState();
        MapCreator map = new MapCreator(4,4, gameState);

        gameState.setPlayer(player);
        gameState.setMap(map);

        CommandProcessor commandProcessor = new CommandProcessor();

        // Add there the available commands
        commandProcessor.registerCommand("look", new Look(gameState));
        commandProcessor.registerCommand("go", new Go(gameState));
        commandProcessor.registerCommand("move", new Go(gameState));
        commandProcessor.registerCommand("stop", new Stop(gameState));
        commandProcessor.registerCommand("help", new Help(gameState));
        commandProcessor.registerCommand("status", new Status(gameState));
        commandProcessor.registerCommand("attack", new Attack(gameState));
        /*
        {
            "look": new LookCommand();
            ...
            }
        */

        Skeleton skeleton = new Skeleton();

//        player.printStats();
//        skeleton.attack(player);
//        player.printStats();

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

        player.superAttack(skeleton);
        player.attack(skeleton);
        player.attack(skeleton);
        player.attack(skeleton);
        player.superAttack(skeleton);
        skeleton.printStats();

        String playerInput;

        // Game Loop
        s.nextLine();
        do {
            System.out.println("For now you are here");
            map.filler();
            map.printer();


            System.out.print("Enter your command: ");

            playerInput = s.nextLine();
            ParsedInput parsedInput = inputParser.parseInput(playerInput);

            String command = parsedInput.getCommand();
            List<String> arguments = List.of(parsedInput.getArguments());
            commandProcessor.executeCommand(command, arguments);

        } while(!Objects.equals(playerInput, "stop"));
    }
}

