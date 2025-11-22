package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntry;

import java.util.Random;

public class Gcd {
    public static void play() {
        final var maxRandomIndex = 2;
        var random = new Random();
        var arrayEntries = new QuizEntry[Engine.ROUNDS];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            var firstNumber = random.nextInt(maxRandomIndex) + 1;
            var secondNumber = random.nextInt(maxRandomIndex) + 1;
            var gcdNumber = gcd(firstNumber, secondNumber);
            var expression = firstNumber + " " + secondNumber;

            arrayEntries[i] = new QuizEntry(expression, String.valueOf(gcdNumber));
        }

        var engine = new Engine("Find the greatest common divisor of given numbers.", arrayEntries);

        engine.check();
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
