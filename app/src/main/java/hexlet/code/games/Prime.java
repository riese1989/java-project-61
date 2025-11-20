package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryString;

import java.util.Random;

public class Prime {
    public static void play() {
        var random = new Random();
        var engine = new Engine("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        var arrayEntries = new QuizEntryString[3];

        for (int i = 0; i < 3; i++) {
            var number = random.nextInt(100) + 1;
            var question = "Question: %s\nYour answer: ".formatted(number);
            var isPrime = isPrime(number) ? "yes" : "no";

            arrayEntries[i] = new QuizEntryString(question, isPrime);
        }

        engine.check(arrayEntries);
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
