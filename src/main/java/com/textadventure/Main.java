package com.textadventure;

import com.textadventure.chapters.Chapter1;
import com.textadventure.characters.Player;
import com.textadventure.weapons.DefensiveWeapon;
import com.textadventure.weapons.OffensiveWeapon;
import com.textadventure.weapons.WeaponEntity;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String name = s.nextLine();

        Player player1 = new Player(name);


        Chapter1 chapter1 = new Chapter1(player1);
        chapter1.start();

    }
}

