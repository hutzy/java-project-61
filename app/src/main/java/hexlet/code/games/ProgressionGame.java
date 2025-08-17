package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.RANDOM;

public class ProgressionGame {

    private static final int MIN_LENGTH = 5;
    private static final int MAX_LENGTH = 11;

    private static final int MIN_START = 1;
    private static final int MAX_START = 21;

    private static final int MIN_STEP = 1;
    private static final int MAX_STEP = 11;

    public static void start(String userName) {
        Engine.runGame(
                "What number is missing in the progression?",
                () -> {
                    int length = RANDOM.nextInt(MIN_LENGTH, MAX_LENGTH);
                    int start = RANDOM.nextInt(MIN_START, MAX_START);
                    int step = RANDOM.nextInt(MIN_STEP, MAX_STEP);
                    int hiddenIndex = RANDOM.nextInt(length);

                    int[] progression = generateProgression(start, step, length);
                    int hiddenNumber = progression[hiddenIndex];

                    StringBuilder question = new StringBuilder();
                    for (int i = 0; i < length; i++) {
                        if (i == hiddenIndex) {
                            question.append("..");
                        } else {
                            question.append(progression[i]);
                        }
                        if (i < length - 1) {
                            question.append(" ");
                        }
                    }

                    return new Engine.GameRound(question.toString(), String.valueOf(hiddenNumber));
                },
                userName
        );
    }

    private static int[] generateProgression(int start, int step, int length) {
        int[] progression = new int[length];
        for (int i = 0; i < length; i++) {
            progression[i] = start + i * step;
        }
        return progression;
    }

}
