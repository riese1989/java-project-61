package hexlet.code.engine;

import hexlet.code.entities.QuizEntryBoolean;
import hexlet.code.entities.QuizEntryInteger;
import hexlet.code.games.Cli;

import java.util.Scanner;

public class Engine {
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

    public void check(QuizEntryBoolean[] array) {
        for (var entity : array) {
            System.out.print(entity.question());

            var answer = scanner.nextLine();

            if (entity.expAnswer() != Boolean.parseBoolean(answer)) {
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
