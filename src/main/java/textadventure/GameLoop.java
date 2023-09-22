package textadventure;

import textadventure.chapters.Chapter1;
import textadventure.characters.Player;

import java.util.Scanner;

public class GameLoop {
    public static void main(String[] args) {

        // Scanner object creation for INPUT
        Scanner s = new Scanner(System.in);
        // What INPUT wants?
        System.out.println("Enter player name: ");
        // Method of Scanner object to retrieve last console INPUT
        String name = s.nextLine();

        // Create player
        Player player1 = new Player(name);

        // Create Chapter1
        Chapter1 chapter1 = new Chapter1(player1);
        // Call chapter1 method .start()
        chapter1.start();

    }
}

