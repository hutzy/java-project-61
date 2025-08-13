package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.RANDOM;

public class CalcGame {

    private static final String[] OPERATORS = {"+", "-", "*"};

    public static void start(String userName) {
        Engine.runGame(
                "What is the result of the expression?",
                () -> {
                    int a = RANDOM.nextInt(1, 21);
                    int b = RANDOM.nextInt(1, 21);
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
