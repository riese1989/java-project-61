package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryInteger;

import java.util.Random;

public class Gcd {
    public static void play() {
        var random = new Random();
        var engine = new Engine("Find the greatest common divisor of given numbers.");
        var arrayEntries = new QuizEntryInteger[3];

        for (int i = 0; i < 3; i++) {
            var firstNumber = random.nextInt(100) + 1;
            var secondNumber = random.nextInt(100) + 1;
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
