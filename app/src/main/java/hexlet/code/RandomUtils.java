package hexlet.code;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static int nextInt(int origin, int bound) {
        return RANDOM.nextInt(origin, bound);
    }

    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }

}
