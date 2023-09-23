package com.textadventure;

import com.textadventure.chapters.Chapter1;
import com.textadventure.entities.Player;

import java.util.List;
import java.util.Scanner;

public class GameLoop {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        System.out.println("Enter player name: ");
        String name = s.nextLine();

        Player player1 = new Player(name);

        Chapter1 chapter1 = new Chapter1(player1);
        chapter1.start();

    }
}

