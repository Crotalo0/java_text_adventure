package com.textadventure.commands;

import com.textadventure.characters.Player;
import com.textadventure.status.GameState;

public class Attack extends CommandEntity {

    private Player player;

    public Attack(GameState gameState) {
        super(gameState);
        // TODO Populate with targets?
        attributes = new String[]{"skeleton"};
    }
    @Override
    public void execute(String... attribute) {
        if (isValidAttribute(attribute[0])) {
            System.out.println("TODO");
        } else {
            System.out.println("Invalid direction");
        }
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getPlayer() {
        return player;
    }
    public void setPlayer(Player player) {
        this.player = player;
    }


}
