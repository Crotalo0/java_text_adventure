package com.textadventure.utils;

import java.util.Arrays;

public class InputParser {
    private final String[] validCommands;

    public InputParser(String[] validCommands) {
        this.validCommands = validCommands;
    }

    public ParsedInput parseInput(String userInput) {
        String[] words = userInput.trim().split("\\s+");
        if (words.length == 0) {
            return new ParsedInput("", new String[0]);
        }
        String command = words[0].toLowerCase();
        String[] arguments = Arrays.copyOfRange(words, 1, words.length);
        for (int i = 0; i<arguments.length; i++) {
            arguments[i] = arguments[i].toLowerCase();
        }

        // Easter egg per Simone 8===D
        return new ParsedInput(command, arguments);
    }

    public boolean isValidCommand(String command) {
        return Arrays.asList(validCommands).contains(command);
    }
}
