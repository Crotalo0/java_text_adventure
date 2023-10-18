package com.textadventure.chapters;

import com.textadventure.characters.entities.CharacterEntity;
import com.textadventure.characters.Player;
import com.textadventure.characters.Skeleton;
import com.textadventure.commands.handling.CommandInitializer;
import com.textadventure.commands.handling.CommandProcessor;
import com.textadventure.map.MapCreator;
import com.textadventure.status.GameState;
import com.textadventure.utils.InputParser;
import com.textadventure.utils.ParsedInput;
import com.textadventure.weapons.DefensiveWeapon;
import com.textadventure.weapons.OffensiveWeapon;
import com.textadventure.weapons.entities.WeaponEntity;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Chapter1 {

    GameState gameState = new GameState();
    CommandInitializer commandProcessor = new CommandInitializer(gameState);
    private final Player player;
    private final Scanner s;
    public Chapter1(Player player, Scanner scanner) {
        this.player = player;
        this.s = scanner;
    }

    public void start() {
        // gameState contains all info on position of player and enemies and map

        gameState.setPlayer(player);
        gameState.setMap(new MapCreator(4,4));
        gameState.setPlayerPosition(new int[] {0,0});

        System.out.println("Choose your combat style:\n1.Aggressive 2.Defensive");
        int chosenCombat = s.nextInt();
        WeaponEntity startingWeapon = (chosenCombat == 1) ?  new OffensiveWeapon() : new DefensiveWeapon();
        // Equip weapon
        player.setWeapon(startingWeapon);

        // Create enemies and add to gameState
        gameState.createEnemy(new Skeleton("skil"));
        gameState.createEnemy(new Skeleton("skel"));
        gameState.createEnemy(new Skeleton("skol"));
        gameState.createEnemy(new Skeleton("skul"));

        // Game Loop
        String playerInput;
        s.nextLine();
        do {
            System.out.println("For now you are here");
            gameState.mapFiller();
            System.out.print("Enter your command: ");
            playerInput = s.nextLine();

            commandProcessor.parseAndExecuteCommand(playerInput);

        } while(!Objects.equals(playerInput, "stop"));
    }
}

