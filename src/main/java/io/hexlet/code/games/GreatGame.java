package io.hexlet.code.games;

import io.hexlet.code.Cli;

public class GreatGame {

    public static String userName;

    public static void greetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = Cli.consoleCaptureString();
        System.out.println("Hello, " + userName + "!\n");
    }
}
