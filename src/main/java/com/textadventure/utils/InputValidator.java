package com.textadventure.utils;

public class InputValidator {

    private InputValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static int rangeInt(String text, Integer lowerBound, Integer upperBound) {
        int input = -1;
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
        return (n>=lowerBound) && (n<=upperBound);
    }
}
