package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryString;

import java.util.Random;

public class Even {
    public static void play() {
        var engine = new Engine("Answer 'yes' if the number is even, otherwise answer 'no'.");
        var random = new Random();
        var arrayEntries = new QuizEntryString[3];

        for(int i = 0; i < 3; i++) {
            var number = random.nextInt(100) + 1;
            var question = "Question: %s\nYour answer: ".formatted(number);
            var expAnswer = number % 2 == 0 ? "yes" : "no";

            arrayEntries[i] = new QuizEntryString(question, expAnswer);
        }

        engine.check(arrayEntries);
    }
}
