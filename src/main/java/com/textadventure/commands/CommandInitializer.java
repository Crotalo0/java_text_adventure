package com.textadventure.commands;

import com.textadventure.commands.*;
import com.textadventure.status.GameState;

public class CommandInitializer extends CommandProcessor {

    public CommandInitializer(GameState gameState) {
        // Add there all available commands
        this.registerCommand("look", new Look(gameState));
        this.registerCommand("go", new Go(gameState));
        this.registerCommand("move", new Go(gameState));
        this.registerCommand("stop", new Stop(gameState));
        this.registerCommand("help", new Help(gameState));
        this.registerCommand("status", new Status(gameState));
        this.registerCommand("attack", new Attack(gameState));
        this.registerCommand("ability", new SuperAttack(gameState));
    }

}
