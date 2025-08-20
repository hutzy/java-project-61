package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.RandomUtils;

import java.util.Arrays;


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
                    int length = RandomUtils.nextInt(MIN_LENGTH, MAX_LENGTH);
                    int start = RandomUtils.nextInt(MIN_START, MAX_START);
                    int step = RandomUtils.nextInt(MIN_STEP, MAX_STEP);
                    int hiddenIndex = RandomUtils.nextInt(length);

                    int[] progression = generateProgression(start, step, length);
                    int hiddenNumber = progression[hiddenIndex];

                    String[] progressionStr = Arrays.stream(progression)
                            .mapToObj(String::valueOf)
                            .toArray(String[]::new);
                    progressionStr[hiddenIndex] = "..";

                    String question = String.join(" ", progressionStr);

                    return new Engine.GameRound(question, String.valueOf(hiddenNumber));
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
