package hexlet.code.games;

import hexlet.code.Engine;

import static hexlet.code.Engine.RANDOM;

public class ProgressionGame {

    public static void start(String userName) {
        Engine.runGame(
                "What number is missing in the progression?",
                () -> {
                    int length = RANDOM.nextInt(5, 11);
                    int start = RANDOM.nextInt(1, 21);
                    int step = RANDOM.nextInt(1, 11);
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
                        if (i < length - 1) question.append(" ");
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
