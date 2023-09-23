package com.textadventure.commands;
import java.util.HashMap;
import java.util.Map;

public class CommandProcessor {

    // Creates a dictionary with {input: command}
    private final Map<String, Command> commands = new HashMap<>();

    // Method that fills the dict with this entry
    public void registerCommand(String commandName, Command command) {
        commands.put(commandName, command);
    }

    // gets the command from the dict and execute it. If null raise something
    public void executeCommand(String commandName) {
        Command command = commands.get(commandName);
        if (command != null) {
            command.execute();
        } else {
            // TODO Raise something
            System.out.println("Invalid command.");
        }
    }
}
