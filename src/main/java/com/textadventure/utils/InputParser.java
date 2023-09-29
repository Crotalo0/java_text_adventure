package com.textadventure.utils;

// There will live the input validation of our project
// 1. Split user input in individual words
// 2. convert all to lowercase

// userInput lo passo col costruttore???
// String[] words = userInput.toLowerCase().split(" ");

// 3. search for a valid word inside
//

// 4. search for eventual parameters
// 5. Error handling
// 6. Organize the command to be digested by the program somewhere else

import java.util.Arrays;

public class InputParser {
    private String[] validCommands;

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
        // Easter egg per Simone 8===D
        return new ParsedInput(command, arguments);
    }

    public boolean isValidCommand(String command) {
        return Arrays.asList(validCommands).contains(command);
    }
}
