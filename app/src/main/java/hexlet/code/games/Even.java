package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryString;

import java.util.Random;

public class Even {
    public static void play() {
        final var quizEntriesCount = 3;
        final var maxRandomIndex = 2;
        var random = new Random();
        var arrayEntries = new QuizEntryString[quizEntriesCount];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            var number = random.nextInt(maxRandomIndex) + 1;
            var expAnswer = number % 2 == 0 ? "yes" : "no";

            arrayEntries[i] = new QuizEntryString(String.valueOf(number), expAnswer);
        }

        var engine = new Engine("Answer 'yes' if the number is even, otherwise answer 'no'.", arrayEntries);
        engine.checkString();
    }
}
