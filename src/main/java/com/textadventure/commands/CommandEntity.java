package com.textadventure.commands;

import lombok.Getter;

@Getter
public abstract class CommandEntity {

    protected String[] attributes;

    public abstract void execute(String... attribute);

    public boolean isValidAttribute(String attr) {
        for (String element : attributes) {
            if (element.equalsIgnoreCase(attr)) return true;
        }
        return false;
    }
}

