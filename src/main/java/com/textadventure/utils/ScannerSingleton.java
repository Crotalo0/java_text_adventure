package com.textadventure.utils;

import java.util.Scanner;

public class ScannerSingleton {
    private static Scanner instance;

    // Public method to get the singleton instance
    public static synchronized Scanner getInstance() {
        if (null == instance) {
            instance = new Scanner(System.in);
        }
        return instance;
    }

    // Close the Scanner when the program is done
    public void closeScanner() {
        if (instance != null) {
            instance.close();
        }
    }

}