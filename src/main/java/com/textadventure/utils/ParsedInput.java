package com.textadventure.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParsedInput {
    private String command;
    private String[] arguments;

    public ParsedInput(String command, String[] arguments) {
        this.command = command;
        this.arguments = arguments;
    }

}
