package com.textadventure.utils;

public class ParsedInput {
    private String command;
    private String[] arguments;

    public ParsedInput(String command, String[] arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArguments() {
        return arguments;
    }
}
