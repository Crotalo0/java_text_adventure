package com.textadventure.commands.handling;

import com.textadventure.commands.entities.CommandEntity;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Getter
public class CommandProcessor {

    private final Map<String, CommandEntity> commands = new HashMap<>();

    protected void registerCommands(Map<String, CommandEntity> look) {
        commands.putAll(look);
    }

    //TODO: better attributes parsing
    public void executeCommand(String commandName, List<String> attributes) {
        CommandEntity commandEntity = commands.get(commandName);
        if (commandEntity != null) {

            // Here no attributes commands
            if (Objects.equals(commandName, "stop")) {
                commandEntity.execute();
            } else if (Objects.equals(commandName, "help")) {
                commandEntity.execute();
            } else if (Objects.equals(commandName, "edoardo")) {
                commandEntity.execute();

            } else if (!attributes.isEmpty()) {
                commandEntity.execute(attributes.getFirst());
            } else {
                System.out.println("Command '" + commandName + "' requires an attribute.");
            }
        } else {
            System.out.println("Invalid command: " + commandName);
        }
    }


}
