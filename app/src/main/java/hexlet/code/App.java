package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Cli;
import hexlet.code.games.Even;
import hexlet.code.games.Gcd;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {

    private static final int EXIT = 0;
    private static final int GREET = 1;
    private static final int EVEN = 2;
    private static final int CALC = 3;
    private static final int GCD = 4;
    private static final int PROGRESSION = 5;
    private static final int PRIME = 6;

    public static void main(String[] args) {
        System.out.print("""
                        Please enter the game number and press Enter.
                        1 - Greet
                        2 - Even
                        3 - Calc
                        4 - GCD
                        5 - Progression
                        6 - Prime
                        0 - Exit
                        Your choice:\s"""
                );
        var scanner = new Scanner(System.in);

        var choice = scanner.nextInt();

        switch (choice)  {
            case EXIT -> {
            }
            case GREET -> Cli.greed();
            case EVEN -> Even.play();
            case CALC -> Calc.play();
            case GCD -> Gcd.play();
            case PROGRESSION -> Progression.play();
            case PRIME -> Prime.play();
            default ->
                    throw new RuntimeException("Incorrect input %d for choice game".formatted(choice));
        }
    }
}
