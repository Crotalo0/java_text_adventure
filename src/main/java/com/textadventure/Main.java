package com.textadventure;

import com.textadventure.chapters.Chapter1;
import com.textadventure.utils.ScannerSingleton;

public class Main {
    public static void main(String[] args) {

        ScannerSingleton.getInstance();

//        String name = s.nextLine();

        Chapter1 chapter1 = new Chapter1();
        chapter1.start();

    }
}

