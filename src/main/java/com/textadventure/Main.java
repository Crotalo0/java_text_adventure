package com.textadventure;

import com.textadventure.chapters.Chapter1;
import com.textadventure.texts.TextLoader;

public class Main {
    public static void main(String[] args) {

        System.out.println(TextLoader.WELCOME);
        Chapter1 chapter1 = new Chapter1();
        chapter1.start();

    }
}

