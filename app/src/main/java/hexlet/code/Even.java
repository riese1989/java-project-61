package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Even {
    public static void play() {
        var name = Cli.greed();

        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        var random = new Random();
        var scanner = new Scanner(System.in);

        for(int attempt = 1; attempt <= 3; attempt++) {
            var number = random.nextInt(100) + 1;

            System.out.printf("Question: %s\nYour answer: ", number);

            var answer = scanner.nextLine();

            if (number % 2 == 0 && "Yes".equalsIgnoreCase(answer) ||
                    number % 2 != 0 && "No".equalsIgnoreCase(answer)) {
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
}
