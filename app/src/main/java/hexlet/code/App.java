package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.GreatGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.io.PrintStream;
import java.util.function.Supplier;

import static java.nio.charset.StandardCharsets.UTF_8;

public class App {

    private static final int EXIT = 0;
    private static final int GREET = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, UTF_8));

        System.out.println("Please enter the game number and press Enter.");
        System.out.println(GREET + " - Greet");
        System.out.println(EVEN + " - Even");
        System.out.println(CALC + " - Calc");
        System.out.println(GCD + " - GCD");
        System.out.println(PROGRESSION + " - Progression");
        System.out.println(PRIME + " - Prime");
        System.out.println(EXIT + " - Exit");


        runGameMenu();
    }

    static void runGameMenu() {
        Supplier<Integer> inputSupplier = Cli::consoleCaptureInt;
        int choice = inputSupplier.get();

        handleMenuChoice(choice);

        System.out.println("Goodbye!");
    }

    private static void handleMenuChoice(int input) {
        switch (input) {
            case GREET -> GreatGame.greetUser();
            case EVEN -> startGameWithGreet(() -> EvenGame.start(GreatGame.getUserName()));
            case CALC -> startGameWithGreet(() -> CalcGame.start(GreatGame.getUserName()));
            case GCD -> startGameWithGreet(() -> GcdGame.start(GreatGame.getUserName()));
            case PROGRESSION -> startGameWithGreet(() -> ProgressionGame.start(GreatGame.getUserName()));
            case PRIME -> startGameWithGreet(() -> PrimeGame.start(GreatGame.getUserName()));
            default -> System.out.println("Invalid input. Please try again.");
        }
        System.out.println();
    }

    private static void startGameWithGreet(Runnable game) {
        if (GreatGame.getUserName() == null) {
            GreatGame.greetUser();
        }
        game.run();
    }
}
