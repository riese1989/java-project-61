package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryString;

import java.util.Random;

public class Prime {
    public static void play() {
        final var quizEntriesCount = 3;
        final var maxRandomNumber = 100;
        var random = new Random();
        var arrayEntries = new QuizEntryString[quizEntriesCount];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            var number = random.nextInt(maxRandomNumber) + 1;
            var isPrime = isPrime(number) ? "yes" : "no";

            arrayEntries[i] = new QuizEntryString(String.valueOf(number), isPrime);
        }

        var engine = new Engine("Answer 'yes' if given number is prime. Otherwise answer 'no'.", arrayEntries);

        engine.checkString();
    }

    private static boolean isPrime(int number) {
        final int firstOddPrimeCheck = 3;

        if (number <= 1) {
            return false;
        }
        if (number == 2) {
            return true;
        }
        if (number % 2 == 0) {
            return false;
        }

        for (int i = firstOddPrimeCheck; i * i <= number; i += 2) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
