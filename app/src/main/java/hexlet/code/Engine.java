package hexlet.code;

import hexlet.code.games.CalcGame;
import hexlet.code.games.GcdGame;
import hexlet.code.games.EvenGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;

import java.util.Scanner;
import java.util.function.Supplier;

public class Engine {

    private static final int ROUNDS = 3;

    public record GameRound(String question, String correctAnswer) {
    }


    public static void runGame(String description, Supplier<GameRound> roundSupplier, String userName) {
        System.out.println(description);
        var scanner = new Scanner(System.in);

        for (int i = 0; i < ROUNDS; i++) {
            var roundData = roundSupplier.get();
            String question = roundData.question();
            String correctAnswer = roundData.correctAnswer();

            System.out.printf("Question: %s%n", question);
            System.out.print("Your answer: ");
            String userAnswer = scanner.nextLine().trim();

            if (!userAnswer.equals(correctAnswer)) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.%n", userAnswer, correctAnswer);
                System.out.printf("Let's try again, %s!%n", userName);
                return;
            }

            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!%n", userName);
    }

    public static void handleMenuChoice(Game choice) {

        if (choice == null) {
            System.out.println("Invalid input. Please try again.");
            System.out.println();
            return;
        }

        switch (choice) {
            case GREET -> Great.greetUser();
            case EVEN -> startGameWithGreet(() -> EvenGame.start(Great.getUserName()));
            case CALC -> startGameWithGreet(() -> CalcGame.start(Great.getUserName()));
            case GCD -> startGameWithGreet(() -> GcdGame.start(Great.getUserName()));
            case PROGRESSION -> startGameWithGreet(() -> ProgressionGame.start(Great.getUserName()));
            case PRIME -> startGameWithGreet(() -> PrimeGame.start(Great.getUserName()));
            case EXIT -> { }
        }
        System.out.println();
    }

    public static void startGameWithGreet(Runnable game) {
        if (Great.getUserName() == null) {
            Great.greetUser();
        }
        game.run();
    }

}
