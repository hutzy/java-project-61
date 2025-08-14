package io.hexlet.code.games;

import io.hexlet.code.Engine;

import java.util.function.Predicate;

import static io.hexlet.code.Engine.RANDOM;

public class EvenGame {

    private static final Predicate<Integer> IS_EVEN = n -> n % 2 == 0;

    public static void start(String userName) {
        Engine.runGame(
                "Answer 'yes' if the number is even, otherwise answer 'no'.",
                () -> {
                    int number = RANDOM.nextInt(100);
                    String correctAnswer = IS_EVEN.test(number) ? "yes" : "no";
                    return new Engine.GameRound(String.valueOf(number), correctAnswer);
                },
                userName
        );
    }

}
