package hexlet.code.engine;

import hexlet.code.entities.QuizEntry;
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
    private final QuizEntry[] arrayQuizEntry;

    public Engine(String msg, QuizEntry[] entries) {
        System.out.println(msg);

        this.arrayQuizEntry = entries;
    }

    public void check() {
        for (var entity : arrayQuizEntry) {
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
