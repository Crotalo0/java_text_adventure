package com.textadventure;

import com.textadventure.chapters.Chapter1;
import com.textadventure.characters.Player;
import com.textadventure.status.GameState;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String name = s.nextLine();

        // Player and GameState creation
        Player p = Player.getInstance();
        GameState.getInstance();

        // Player settings
        p.setName(name);

        Chapter1 chapter1 = new Chapter1();
        chapter1.start();

    }
}

