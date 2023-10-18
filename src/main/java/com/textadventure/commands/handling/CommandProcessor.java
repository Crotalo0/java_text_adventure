package com.textadventure.commands.handling;
import com.textadventure.commands.entities.CommandEntity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CommandProcessor {

    // Creates a dictionary with {input: command}
    private final Map<String, CommandEntity> commands = new HashMap<>();

    // Method that fills the dict with this entry
    public void registerCommand(String commandName, CommandEntity commandEntity) {
        commands.put(commandName, commandEntity);
    }

    // gets the command from the dict and execute it. If null raise something
    public void executeCommand(String commandName, List<String> attributes) {
        CommandEntity commandEntity = commands.get(commandName);
        if (commandEntity != null) {

            // Here no attributes commands
            if (Objects.equals(commandName, "stop")) {
                commandEntity.execute();
            } else if (Objects.equals(commandName, "help")) {
                commandEntity.execute();

            } else if (!attributes.isEmpty()) {
                commandEntity.execute(attributes.get(0));
            } else {
                System.out.println("Command '" + commandName + "' requires an attribute.");
            }
        } else {
            System.out.println("Invalid command: " + commandName);
        }
    }

    public Map<String, CommandEntity> getCommands() {
        return commands;
    }
}
