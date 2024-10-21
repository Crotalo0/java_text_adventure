package com.textadventure.commands.handling;

import com.textadventure.commands.*;
import com.textadventure.eastereggs.EdoEgg;
import com.textadventure.utils.ParsedInput;

import java.util.Map;

public class CommandInitializer extends CommandProcessor {

    private static CommandInitializer instance;

    public CommandInitializer() {
        this.registerCommands(Map.of(
                "look", new Look(),
                "go", new Go(), "move", new Go(),
                "stop", new Stop(), "quit", new Stop(),
                "help", new Help(),
                "status", new Status(),
                "attack", new Attack(),
                "ability", new Ability(),
                "edoardo", EdoEgg.getInstance())
        );
    }

    public static CommandInitializer getInstance() {
        if (null == instance) {
            instance = new CommandInitializer();
        }
        return instance;
    }

    public void parseAndExecuteCommand(String playerInput) {
        ParsedInput parsedInput = parseInput(playerInput);
        if (null != parsedInput)
            executeCommand(parsedInput.getCommand(), parsedInput.getArgument());
    }

}
