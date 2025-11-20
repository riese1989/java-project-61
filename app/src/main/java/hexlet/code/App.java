package hexlet.code;

import hexlet.code.games.*;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.print("Please enter the game number and press Enter.\n" +
                "1 - Greet\n" +
                "2 - Even\n" +
                "3 - Calc\n" +
                "4 - GCD\n" +
                "5 - Progression\n" +
                "6 - Prime\n" +
                "0 - Exit\n" +
                "Your choice: "
                );
        var scanner = new Scanner(System.in);

        var choice = scanner.nextInt();

        switch (choice)  {
            case 0 -> {
                return;
            }
            case 1 -> Cli.greed();
            case 2 -> Even.play();
            case 3 -> Calc.play();
            case 4 -> Gcd.play();
            case 5 -> Progression.play();
            case 6 -> Prime.play();
            default ->
                    throw new IllegalStateException("Unexpected value: " + choice);
        };
    }
}
