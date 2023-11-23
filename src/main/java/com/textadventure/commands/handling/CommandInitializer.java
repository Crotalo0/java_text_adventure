package com.textadventure.commands.handling;

import com.textadventure.commands.*;
import com.textadventure.eastereggs.EdoEgg;
import com.textadventure.utils.InputParser;
import com.textadventure.utils.ParsedInput;

import java.util.List;

public class CommandInitializer extends CommandProcessor {

    // Singleton pattern
    private static CommandInitializer instance;
    InputParser inputParser;

    public CommandInitializer() {
        // Add there all available commands
        this.registerCommand("look", new Look());
        this.registerCommand("go", new Go());
        this.registerCommand("move", new Go());
        this.registerCommand("stop", new Stop());
        this.registerCommand("help", new Help());
        this.registerCommand("status", new Status());
        this.registerCommand("attack", new Attack());
        this.registerCommand("ability", new SuperAttack());
        this.registerCommand("edoardo", EdoEgg.getInstance());
        // Add there new commands

        loadAllCommands();
    }

    public static CommandInitializer getInstance() {
        if (null == instance) {
            instance = new CommandInitializer();
        }
        return instance;
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
