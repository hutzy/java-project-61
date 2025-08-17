package hexlet.code.games;

import hexlet.code.Cli;

public class GreatGame {

    private static String userName;

    public static String getUserName() {
        return userName;
    }


    public static void greetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        userName = Cli.consoleCaptureString();
        System.out.println("Hello, " + userName + "!\n");
    }
}
