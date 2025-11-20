package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryBoolean;

import java.util.Random;

public class Even {
    public static void play() {
        var engine = new Engine("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var random = new Random();
        var arrayEntries = new QuizEntryBoolean[3];

        for(int i = 0; i < 3; i++) {
            var number = random.nextInt(100) + 1;
            var question = "Question: %s\nYour answer: ".formatted(number);

            arrayEntries[i] = new QuizEntryBoolean(question, number % 2 == 0);
        }

        engine.check(arrayEntries);
    }
}
