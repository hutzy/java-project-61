package hexlet.code;

import java.io.PrintStream;
import java.util.Scanner;
import java.util.function.Supplier;

import static java.nio.charset.StandardCharsets.UTF_8;

public class App {

    public static void main(String[] args) {
        System.setOut(new PrintStream(System.out, true, UTF_8));
        runGameMenu();
    }

    static void runGameMenu() {
        System.out.println("Please enter the game number and press Enter.");
        for (Game game : Game.values()) {
            System.out.println(game.getCode() + " - " + game.getTitle());
        }

        Supplier<Integer> inputSupplier = App::consoleCaptureInt;
        int choice = inputSupplier.get();

        Engine.handleMenuChoice(Game.findByCode(choice));

        System.out.println("Goodbye!");
    }

    private static int consoleCaptureInt() {
        var sc = new Scanner(System.in);
        return sc.nextInt();
    }

}
