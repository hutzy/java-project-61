package hexlet.code.games;

import hexlet.code.Engine;

import java.util.function.Predicate;

import static hexlet.code.Engine.RANDOM;

public class EvenGame {

    private static final Predicate<Integer> IS_EVEN = n -> n % 2 == 0;
    private static final int BOUND = 100;

    public static void start(String userName) {
        Engine.runGame(
                "Answer 'yes' if the number is even, otherwise answer 'no'.",
                () -> {
                    int number = RANDOM.nextInt(BOUND);
                    String correctAnswer = IS_EVEN.test(number) ? "yes" : "no";
                    return new Engine.GameRound(String.valueOf(number), correctAnswer);
                },
                userName
        );
    }

}
