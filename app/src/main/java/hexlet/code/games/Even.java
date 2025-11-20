package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryString;

import java.util.Random;

public class Even {
    private static final int QUIZ_ENTRIES_COUNT = 3;
    private static final int MAX_RANDOM_NUMBER  = 100;

    public static void play() {
        var engine = new Engine("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var random = new Random();
        var arrayEntries = new QuizEntryString[QUIZ_ENTRIES_COUNT];

        for (int i = 0; i < QUIZ_ENTRIES_COUNT; i++) {
            var number = random.nextInt(MAX_RANDOM_NUMBER) + 1;
            var question = "Question: %s\nYour answer: ".formatted(number);
            var expAnswer = number % 2 == 0 ? "yes" : "no";

            arrayEntries[i] = new QuizEntryString(question, expAnswer);
        }

        engine.check(arrayEntries);
    }
}
