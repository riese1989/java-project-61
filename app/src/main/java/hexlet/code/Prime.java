package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Prime {
    public static void play() {
        var name = Cli.greed();
        var random = new Random();
        var scanner = new Scanner(System.in);

        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        for (int attempt = 1; attempt <= 3; attempt++) {
            var number = random.nextInt(100) + 1;

            System.out.printf("Question %s\n" +
                    "Your answer: ", number);

            var answer = scanner.nextLine();
            var isPrime = isPrime(number);

            if (isPrime && "Yes".equalsIgnoreCase(answer) ||
                    !isPrime && "No".equalsIgnoreCase(answer)) {
                System.out.println("Correct!");

                continue;
            }

            System.out.printf("""
                    '%s' is wrong answer ;(. Correct answer was '%s'.
                    Let's try again, %s!
                    """, answer, "Yes".equalsIgnoreCase(answer) ? "No" : "Yes", name);

            return;
        }

        System.out.printf("Congratulations, %s!", name);
    }

    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
