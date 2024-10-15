package com.textadventure.commands.handling;

import com.textadventure.commands.*;
import com.textadventure.eastereggs.EdoEgg;
import com.textadventure.utils.InputParser;
import com.textadventure.utils.ParsedInput;

import java.util.List;
import java.util.Map;

public class CommandInitializer extends CommandProcessor {

    private static CommandInitializer instance;
    InputParser inputParser;

    public CommandInitializer() {
        this.registerCommands(Map.of(
                "look", new Look(),
                "go", new Go(),"move", new Go(),
                "stop", new Stop(),"quit", new Stop(),
                "help", new Help(),
                "status", new Status(),
                "attack", new Attack(),
                "ability", new SuperAttack(),
                "edoardo", EdoEgg.getInstance())
        );
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
