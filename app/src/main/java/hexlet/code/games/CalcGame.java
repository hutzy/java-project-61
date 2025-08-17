package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.RANDOM;

public class CalcGame {

    private static final String[] OPERATORS = {"+", "-", "*"};
    private static final int BOUND = 21;
    private static final int ORIGIN = 1;

    public static void start(String userName) {
        Engine.runGame(
                "What is the result of the expression?",
                () -> {
                    int a = RANDOM.nextInt(ORIGIN, BOUND);
                    int b = RANDOM.nextInt(ORIGIN, BOUND);
                    String op = OPERATORS[RANDOM.nextInt(OPERATORS.length)];
                    int correct = calculate(a, b, op);
                    return new Engine.GameRound(a + " " + op + " " + b, String.valueOf(correct));
                },
                userName
        );
    }

    private static int calculate(int a, int b, String operator) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            default -> throw new IllegalStateException("Unexpected value: " + operator);
        };
    }

}
