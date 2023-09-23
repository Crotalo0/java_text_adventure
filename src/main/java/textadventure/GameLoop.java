package textadventure;

import textadventure.chapters.Chapter1;
import textadventure.characters.Player;
import textadventure.commands.CommandProcessor;
import textadventure.commands.GoCommand;
import textadventure.commands.LookCommand;
import textadventure.status.GameState;

import java.util.Objects;
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
        Chapter1 chapter1 = new Chapter1(player1);
        chapter1.start();

        // Command processing test
        CommandProcessor commandProcessor = new CommandProcessor();
        // Fill dicts with commands
        commandProcessor.registerCommand("look", new LookCommand());
        commandProcessor.registerCommand("go", new GoCommand("north"));


        String playerInput;
        do {
            System.out.print("Enter your command: ");
            playerInput = s.nextLine();
            // Parse and execute the command
            commandProcessor.executeCommand(playerInput);
        }
        while(!Objects.equals(playerInput, "stop"));


    }
}

