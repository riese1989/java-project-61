package hexlet.code.engine;

import hexlet.code.entities.QuizEntryString;
import hexlet.code.entities.QuizEntryInteger;
import hexlet.code.games.Cli;

import java.util.Scanner;

public final class Engine {
    private final String name = Cli.greed();;
    private final Scanner scanner = new Scanner(System.in);
    public static final int ROUNDS = 3;
    private static final String MASK_QUESTION = """
            Question: %s
            Your answer:\s
            """;
    private QuizEntryInteger[] arrayQuizEntryInteger;
    private QuizEntryString[] arrayQuizEntryString;

    public Engine(String msg, QuizEntryInteger[] entries) {
        System.out.println(msg);

        this.arrayQuizEntryInteger = entries;
    }

    public Engine(String msg, QuizEntryString[] entries) {
        System.out.println(msg);

        this.arrayQuizEntryString = entries;
    }

    public void checkInteger() {
        for (var entity : arrayQuizEntryInteger) {
            System.out.printf(MASK_QUESTION, entity.expression());

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

    public void checkString() {
        for (var entity : arrayQuizEntryString) {
            System.out.printf(MASK_QUESTION, entity.expression());

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
