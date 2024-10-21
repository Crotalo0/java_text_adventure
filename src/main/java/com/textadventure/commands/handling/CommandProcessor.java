package com.textadventure.commands.handling;

import com.textadventure.commands.CommandEntity;
import com.textadventure.utils.ParsedInput;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class CommandProcessor {

    private final Map<String, CommandEntity> commands = new HashMap<>();

    protected void registerCommands(Map<String, CommandEntity> look) {
        commands.putAll(look);
    }

    public void executeCommand(String commandName, String attribute) {
        CommandEntity commandEntity = commands.get(commandName);
        if (commandEntity != null) {
            String[] attributes = commandEntity.getAttributes();
            if (null == attributes) {
                commandEntity.execute();
                return;
            }
            if (attribute.isEmpty()) {
                System.out.println("Command '" + commandName + "' requires an attribute.");
                return;
            }
            commandEntity.execute(attribute);
        } else {
            System.out.println("Invalid command: " + commandName);
        }
    }

    public ParsedInput parseInput(String userInput) {
        String trimmed = userInput.trim().toLowerCase();
        if (!trimmed.contains(" "))
            return new ParsedInput(trimmed, "");

        String[] input = trimmed.split("\\s+");
        if (input.length > 2) {
            System.out.println("Only one attribute");
            return null;
        }
        return new ParsedInput(input[0], input[1]);
    }
}
