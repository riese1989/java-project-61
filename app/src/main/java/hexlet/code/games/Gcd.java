package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryInteger;

import java.util.Random;

public class Gcd {
    private static final int QUIZ_ENTRIES_COUNT = 3;
    private static final int MAX_RANDOM_NUMBER  = 100;

    public static void play() {
        var random = new Random();
        var engine = new Engine("Find the greatest common divisor of given numbers.");
        var arrayEntries = new QuizEntryInteger[QUIZ_ENTRIES_COUNT];

        for (int i = 0; i < QUIZ_ENTRIES_COUNT; i++) {
            var firstNumber = random.nextInt(MAX_RANDOM_NUMBER) + 1;
            var secondNumber = random.nextInt(MAX_RANDOM_NUMBER) + 1;
            var gcdNumber = gcd(firstNumber, secondNumber);
            var question = "Question: %s %s \nYour answer: "
                    .formatted(firstNumber, secondNumber);

            arrayEntries[i] = new QuizEntryInteger(question, gcdNumber);
        }

        engine.check(arrayEntries);
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
