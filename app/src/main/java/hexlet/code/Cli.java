package hexlet.code;

import java.util.Scanner;

public class Cli {

    static String consoleCapture() {
        var sc = new Scanner(System.in);
        System.out.println("May I have your name?");
        return sc.nextLine();
    }


}
