package com.textadventure.utils;

import lombok.Data;

@Data
public class ParsedInput {
    private String command;
    private String argument;

    public ParsedInput(String command, String argument) {
        this.command = command;
        this.argument = argument;
    }
}
