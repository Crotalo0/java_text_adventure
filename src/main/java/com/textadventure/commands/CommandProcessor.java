package com.textadventure.commands;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandProcessor {

    // Creates a dictionary with {input: command}
    private final Map<String, Command> commands = new HashMap<>();

    // Method that fills the dict with this entry
    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    // gets the command from the dict and execute it. If null raise something
    public void executeCommand(String commandName, List<String> attributes) {
        Command command = commands.get(commandName);
        if (command != null) {
            if (!attributes.isEmpty()) {
                command.execute(attributes.get(0));
            } else {
                System.out.println("Command '" + commandName + "' requires an attribute.");
            }
        } else {
            System.out.println("Invalid command: " + commandName);
        }
    }

    public Map<String, Command> getCommands() {
        return commands;
    }
}
