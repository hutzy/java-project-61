package io.hexlet.code;

import io.hexlet.code.games.CalcGame;
import io.hexlet.code.games.EvenGame;
import io.hexlet.code.games.GcdGame;
import io.hexlet.code.games.ProgressionGame;
import io.hexlet.code.games.PrimeGame;
import io.hexlet.code.games.GreatGame;

import java.io.PrintStream;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static java.nio.charset.StandardCharsets.UTF_8;

public class App {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, UTF_8));
        runGameMenu();
    }

    static void runGameMenu() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");

        Supplier<Integer> inputSupplier = Cli::consoleCaptureInt;

        Stream.generate(inputSupplier)
                .takeWhile(input -> input != 0)
                .forEach(App::handleMenuChoice);

        System.out.println("Goodbye!");
    }

    private static void handleMenuChoice(int input) {
        switch (input) {
            case 1 -> GreatGame.greetUser();
            case 2 -> startGameWithGreet(() -> EvenGame.start(GreatGame.userName));
            case 3 -> startGameWithGreet(() -> CalcGame.start(GreatGame.userName));
            case 4 -> startGameWithGreet(() -> GcdGame.start(GreatGame.userName));
            case 5 -> startGameWithGreet(() -> ProgressionGame.start(GreatGame.userName));
            case 6 -> startGameWithGreet(() -> PrimeGame.start(GreatGame.userName));
            default -> System.out.println("Invalid input. Please try again.");
        }
        System.out.println();
    }

    private static void startGameWithGreet(Runnable game) {
        if (GreatGame.userName == null) {
            GreatGame.greetUser();
        }
        game.run();
    }
}
