package hexlet.code.games;

import hexlet.code.Engine;

import java.util.Random;

public class GcdGame {

    private static final Random RANDOM = new Random();

    public static void start(String userName) {
        Engine.runGame(
                "Find the greatest common divisor of given numbers.",
                () -> {
                    int a = RANDOM.nextInt(1, 101);
                    int b = RANDOM.nextInt(1, 101);
                    int correctAnswer = gcd(a, b);
                    return new Engine.GameRound(a + " " + b, String.valueOf(correctAnswer));
                },
                userName
        );
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
