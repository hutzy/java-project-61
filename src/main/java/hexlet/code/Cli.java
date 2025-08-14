package hexlet.code;

import java.util.Scanner;

public class Cli {

    public static String consoleCaptureString() {
        var sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public static int consoleCaptureInt() {
        var sc = new Scanner(System.in);
        return sc.nextInt();
    }


}
