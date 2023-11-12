package com.textadventure.commands.handling;

import com.textadventure.commands.*;
import com.textadventure.status.GameState;
import com.textadventure.utils.InputParser;
import com.textadventure.utils.ParsedInput;

import java.util.List;

public class CommandInitializer extends CommandProcessor {
    InputParser inputParser;

    public CommandInitializer(GameState gameState) {
        // Add there all available commands
        this.registerCommand("look", new Look(gameState));
        this.registerCommand("go", new Go(gameState));
        this.registerCommand("move", new Go(gameState));
        this.registerCommand("stop", new Stop(gameState));
        this.registerCommand("help", new Help(gameState));
        this.registerCommand("status", new Status(gameState));
        this.registerCommand("attack", new Attack(gameState));
        this.registerCommand("ability", new SuperAttack(gameState));
        // Add there new commands

        loadAllCommands();
    }
    public void loadAllCommands() {
        this.inputParser = new InputParser(getCommands().keySet().toArray(new String[0]));
    }
    public void parseAndExecuteCommand(String playerInput) {
        ParsedInput parsedInput = inputParser.parseInput(playerInput);
        String command = parsedInput.getCommand();
        List<String> arguments = List.of(parsedInput.getArguments());
        executeCommand(command, arguments);
    }
}
