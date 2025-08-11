package hexlet.code;

import java.io.PrintStream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class App {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, UTF_8));

        System.out.println("Welcome to the Brain Games!");
        var name = Cli.consoleCapture();
        System.out.println("Hello, " + name + "!");
    }

}
