package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Progression {
    public static void play() {
        var name = Cli.greed();
        var random = new Random();

        System.out.println("What number is missing in the progression?");

        for (int attempt = 1; attempt <=3; attempt++) {
            var missedIndex = random.nextInt(5);
            var interval = random.nextInt(100) + 1;
            var startValue = random.nextInt(100) + 1;
            int[] progression = new int[5];

            for (int i = 0; i < 5; i++) {
                progression[i] = startValue + i * interval;
            }

            var listString = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                if (i != missedIndex) {
                    listString.append(progression[i]).append(" ");
                } else {
                    listString.append(".. ");
                }
            }

            System.out.printf("Question %s\n" +
                    "Your answer: ", listString);

            var scanner = new Scanner(System.in);

            var answer = scanner.nextInt();

            if (answer != progression[missedIndex]) {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, answer, progression[missedIndex], name);

                return;
            }
            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!", name);
    }
}
