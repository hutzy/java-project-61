package hexlet.code;

public enum Game {

    GREET(1, "Greet"),
    EVEN(2, "Even"),
    CALC(3, "Calc"),
    GCD(4, "GCD"),
    PROGRESSION(5, "Progression"),
    PRIME(6, "Prime"),
    EXIT(0, "Exit");

    private final int code;
    private final String title;

    Game(int codeValue, String titleValue) {
        this.code = codeValue;
        this.title = titleValue;
    }

    public int getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public static Game findByCode(int code) {
        for (Game game : values()) {
            if (game.code == code) {
                return game;
            }
        }
        return null;
    }
}
