package hexlet.code.engine;

import hexlet.code.entities.QuizEntryString;
import hexlet.code.entities.QuizEntryInteger;
import hexlet.code.games.Cli;

import java.util.Scanner;

public final class Engine {
    private final String name;
    private final Scanner scanner;

    public Engine(String msg) {
        scanner = new Scanner(System.in);
        name = Cli.greed();
        System.out.println(msg);
    }

    public void check(QuizEntryInteger[] array) {
        for (var entity : array) {
            System.out.print(entity.question());

            var answer = scanner.nextInt();

            if (answer != entity.expAnswer()) {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, answer, entity.expAnswer(), name);

                return;
            }

            System.out.println("Correct!");

        }

        System.out.printf("Congratulations, %s!", name);
    }

    public void check(QuizEntryString[] array) {
        for (var entity : array) {
            System.out.print(entity.question());

            var answer = scanner.nextLine().toLowerCase();

            if (!answer.equalsIgnoreCase(entity.expAnswer())) {
                System.out.printf("""
                        '%s' is wrong answer ;(. Correct answer was '%s'.
                        Let's try again, %s!
                        """, answer, entity.expAnswer(), name);

                return;
            }

            System.out.println("Correct!");
        }

        System.out.printf("Congratulations, %s!", name);
    }
}
