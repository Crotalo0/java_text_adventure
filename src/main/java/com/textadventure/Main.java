package com.textadventure;

import com.textadventure.chapters.Chapter1;
import com.textadventure.entities.Player;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String name = s.nextLine();

        Player player1 = new Player(name);
        System.out.println("Choose your combat style:\n1. Melee\2.Ranged");
        String chosenCombat = s.nextLine();
        Chapter1 chapter1 = new Chapter1(player1);
        chapter1.start();

    }
}

