package com.textadventure.utils;

/**
 * Static class used to get a numeric input given a list of entries
 */
public class InputValidator {

    private InputValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static int choiceInRange(String text, Integer lowerBound, Integer upperBound) {
        int input;
        System.out.print(text);
        while (true) {
            if (ScannerSingleton.getInstance().hasNextInt()) {
                input = ScannerSingleton.getInstance().nextInt();
                if (inRange(lowerBound, upperBound, input)) {
                    break;
                }
            }
            System.out.printf("Invalid Input. Provide an integer in range [%d,%d].%n", lowerBound, upperBound);
            System.out.print(text);
            ScannerSingleton.getInstance().nextLine();
        }
        return input;
    }

    public static boolean inRange(int lowerBound, int upperBound, int n) {
        return (n >= lowerBound) && (n <= upperBound);
    }
}
