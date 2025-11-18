package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Gcd {
    public static void play() {
        var name = Cli.greed();
        var random = new Random();
        var scanner = new Scanner(System.in);

        System.out.println("Find the greatest common divisor of given numbers.");

        for (int attempt = 1; attempt <= 3; attempt++) {
            var firstNumber = random.nextInt(100) + 1;
            var secondNumber = random.nextInt(100) + 1;
            var gcdNumber = gcd(firstNumber, secondNumber);

            System.out.printf("Question %s %s \n" +
                    "Your answer: ", firstNumber, secondNumber);

            var answer = scanner.nextInt();

            if (answer != gcdNumber) {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, answer, gcdNumber, name);

                return;
            }

            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!", name);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
