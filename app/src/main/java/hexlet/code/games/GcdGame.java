package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;


public class GcdGame {

    private static final int BOUND = 101;
    private static final int ORIGIN = 1;

    public static void start(String userName) {
        Engine.runGame(
                "Find the greatest common divisor of given numbers.",
                () -> {
                    int a = RandomUtils.nextInt(ORIGIN, BOUND);
                    int b = RandomUtils.nextInt(ORIGIN, BOUND);
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
