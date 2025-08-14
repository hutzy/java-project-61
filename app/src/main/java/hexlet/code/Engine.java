package hexlet.code;

import java.util.Random;
import java.util.Scanner;
import java.util.function.Supplier;

public class Engine {

    private static final int ROUNDS = 3;
    public static final Random RANDOM = new Random();

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

}
