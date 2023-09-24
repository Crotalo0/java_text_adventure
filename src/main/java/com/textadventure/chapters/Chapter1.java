package com.textadventure.chapters;

import com.textadventure.commands.CommandProcessor;
import com.textadventure.commands.GoCommand;
import com.textadventure.commands.LookCommand;
import com.textadventure.commands.StopCommand;
import com.textadventure.entities.Player;
import com.textadventure.entities.Skeleton;
import com.textadventure.map.MapCreator;
import com.textadventure.status.GameState;
import com.textadventure.utils.InputParser;
import com.textadventure.utils.ParsedInput;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Chapter1 {
    private Player player;

    public Chapter1(Player player) {
        this.player = player;
    }

    public void start() {

        GameState gameState = new GameState();
        MapCreator map = new MapCreator(4,4, gameState);

        gameState.setPlayer(player);
        gameState.setMap(map);

        CommandProcessor commandProcessor = new CommandProcessor();

        // Add there the available commands
        commandProcessor.registerCommand("look", new LookCommand(gameState));
        commandProcessor.registerCommand("go", new GoCommand(gameState));
        commandProcessor.registerCommand("stop", new StopCommand(gameState));

        Skeleton skeleton = new Skeleton();

        player.printStats();
        skeleton.attack(player);
        player.printStats();

        gameState.setPlayerPosition(new int[] {0,0});

        // TEST USER INPUT
        String[] validCommands = commandProcessor.getCommands().keySet().toArray(new String[0]);
        InputParser inputParser = new InputParser(validCommands);

        Scanner s = new Scanner(System.in);
        String playerInput;

        // Game Loop
        do {
            System.out.println("For now you are here");
            map.filler();
            map.printer();

            System.out.print("Enter your command: ");
            playerInput = s.nextLine();
            ParsedInput parsedInput = inputParser.parseInput(playerInput);

            if (inputParser.isValidCommand(parsedInput.getCommand())) {

                String command = parsedInput.getCommand();
                List<String> arguments = List.of(parsedInput.getArguments());
                commandProcessor.executeCommand(command, arguments);
            } else {

                System.out.println("Invalid command. Please try again.");
            }
        } while(!Objects.equals(playerInput, "stop"));
    }
}

