package com.textadventure.chapters;

import com.textadventure.characters.Player;
import com.textadventure.characters.Skeleton;
import com.textadventure.commands.handling.CommandInitializer;
import com.textadventure.map.MapCreator;
import com.textadventure.status.GameState;
import com.textadventure.weapons.DefensiveWeapon;
import com.textadventure.weapons.OffensiveWeapon;
import com.textadventure.weapons.entities.WeaponEntity;
import java.util.Objects;
import java.util.Scanner;

public class Chapter1 {
    private final GameState gs = GameState.getInstance();
    private final CommandInitializer commandProcessor;
    private final Scanner s;
    public Chapter1(Scanner scanner) {
        this.s = scanner;
        this.commandProcessor = new CommandInitializer();
    }

    public void start() {
        // gameState contains all info on position of player and enemies and map
        gs.setMap(new MapCreator(4,4));
        gs.setPlayerPosition(new int[] {0,0});

        // TODO : move in player
        System.out.println("Choose your combat style:\n1.Aggressive 2.Defensive");
        int chosenCombat = s.nextInt();
        WeaponEntity startingWeapon = (chosenCombat == 1) ?  new OffensiveWeapon() : new DefensiveWeapon();
        // Equip weapon
        Player.getInstance().setWeapon(startingWeapon);
        // TODO End

        // Create enemies and add to gameState
        gs.createEnemy(new Skeleton("skil"));
        gs.createEnemy(new Skeleton("skel"));
        gs.createEnemy(new Skeleton("skol"));
        gs.createEnemy(new Skeleton("skul"));

        // Game Loop
        runGameLoop();

    }
    // TODO: move in another class
    private void runGameLoop() {
        String playerInput;
        s.nextLine();
        do {
            System.out.println("For now you are here");
            gs.mapFiller();
            System.out.print("Enter your command: ");
            playerInput = s.nextLine();

            commandProcessor.parseAndExecuteCommand(playerInput);

        } while(!Objects.equals(playerInput, "stop"));
    }
}

