package com.textadventure.chapters;

import com.textadventure.commands.CommandProcessor;
import com.textadventure.commands.GoCommand;
import com.textadventure.commands.LookCommand;
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
        MapCreator map = new MapCreator(3,3, gameState);

        gameState.setPlayer(player);
        gameState.setMap(map);
        // Pass gameState to GoCommand??

        CommandProcessor commandProcessor = new CommandProcessor();

        // Add there the available commands
        commandProcessor.registerCommand("look", new LookCommand(gameState));
        commandProcessor.registerCommand("go", new GoCommand(gameState));

        Skeleton skeleton = new Skeleton();
        map.filler();
        map.printer();

//        player.printStats();
//        skeleton.printStats();

        gameState.setPlayerPosition(new int[] {0,0});
        int[] posTestInit = gameState.getPlayerPosition();
        System.out.printf("Initial position -- x: %d, y: %d%n",posTestInit[0], posTestInit[1]);

        gameState.moveTo(new int[] {0,1});
        int[] posTest = gameState.getPlayerPosition();
        System.out.printf("After position -- x: %d, y: %d%n",posTest[0], posTest[1]);
        System.out.println("Position on the map:");
        map.filler();
        map.printer();

        // TEST USER INPUT
        String[] validCommands = commandProcessor.getCommands().keySet().toArray(new String[0]);
        InputParser inputParser = new InputParser(validCommands);


        Scanner s = new Scanner(System.in);
        String playerInput;
        do {
            System.out.print("Enter your command: ");
            playerInput = s.nextLine();
            ParsedInput parsedInput = inputParser.parseInput(playerInput);

            if (inputParser.isValidCommand(parsedInput.getCommand())) {

                String command = parsedInput.getCommand();
                List<String> arguments = List.of(parsedInput.getArguments());
                commandProcessor.executeCommand(command, arguments);
                map.filler();
                map.printer();
            } else {

                System.out.println("Invalid command. Please try again.");
            }
        }
        while(!Objects.equals(playerInput, "stop"));

    }

}
