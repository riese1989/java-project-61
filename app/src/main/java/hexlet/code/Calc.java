package hexlet.code;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Calc {
    public static void play() {
        var random = new Random();
        var name = Cli.greed();
        var signList = List.of('-', '+', '*');

        System.out.println("What is the result of the expression?");

        for (int i = 1; i <= 3; i++) {
            var scanner = new Scanner(System.in);
            var firstNumber = random.nextInt(100) + 1;
            var secondNumber = random.nextInt(100) + 1;
            var index = random.nextInt(2) + 1;
            var sign = signList.get(index);
            int expectedValue = 0;

            if (sign.equals('-')) {
                expectedValue = firstNumber - secondNumber;
            }

            if (sign.equals('+')) {
                expectedValue = firstNumber + secondNumber;
            }

            if (sign.equals('*')) {
                expectedValue = firstNumber * secondNumber;
            }

            System.out.printf("Question: %s %s %s\n" +
                    "Your answer: ", firstNumber, sign, secondNumber);

            var answer = scanner.nextInt();

            if (answer != expectedValue) {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, answer, expectedValue, name);

                return;
            }
            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!", name);
    }
}
