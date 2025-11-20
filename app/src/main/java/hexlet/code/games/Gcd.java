package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryInteger;

import java.util.Random;

public class Gcd {
    public static void play() {
        final var quizEntriesCount = 3;
        final var maxRandomIndex = 2;
        var random = new Random();
        var arrayEntries = new QuizEntryInteger[quizEntriesCount];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            var firstNumber = random.nextInt(maxRandomIndex) + 1;
            var secondNumber = random.nextInt(maxRandomIndex) + 1;
            var gcdNumber = gcd(firstNumber, secondNumber);
            var expression = firstNumber + " " + secondNumber;

            arrayEntries[i] = new QuizEntryInteger(expression, gcdNumber);
        }

        var engine = new Engine("Find the greatest common divisor of given numbers.", arrayEntries);

        engine.checkInteger();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
