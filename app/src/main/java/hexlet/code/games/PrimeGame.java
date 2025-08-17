package hexlet.code.games;

import hexlet.code.Engine;

import java.util.function.Predicate;

import static hexlet.code.Engine.RANDOM;

public class PrimeGame {

    private static final Predicate<Integer> IS_PRIME = PrimeGame::isPrime;
    private static final int MAX_RANDOM_NUMBER = 100;
    private static final int MIN_RANDOM_NUMBER = 2;

    public static void start(String userName) {
        Engine.runGame(
                "Answer 'yes' if given number is prime. Otherwise answer 'no'.",
                () -> {
                    int number = RANDOM.nextInt(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
                    String correctAnswer = IS_PRIME.test(number) ? "yes" : "no";
                    return new Engine.GameRound(String.valueOf(number), correctAnswer);
                },
                userName
        );
    }

    private static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
