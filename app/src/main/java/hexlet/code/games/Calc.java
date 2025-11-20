package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryInteger;

import java.util.List;
import java.util.Random;

public class Calc {
    private static final int QUIZ_ENTRIES_COUNT = 3;
    private static final int MAX_RANDOM_INDEX  = 2;
    private static final int MAX_RANDOM_NUMBER  = 100;

    public static void play() {
        var random = new Random();
        var signList = List.of('-', '+', '*');
        var engine = new Engine("What is the result of the expression?");
        var quizEntries = new QuizEntryInteger[QUIZ_ENTRIES_COUNT];

        for (int i = 0; i < QUIZ_ENTRIES_COUNT; i++) {
            int firstNumber = random.nextInt(MAX_RANDOM_NUMBER) + 1;
            int secondNumber = random.nextInt(MAX_RANDOM_NUMBER) + 1;
            var index = random.nextInt(MAX_RANDOM_INDEX) + 1;
            var sign = signList.get(index);
            var question = "Question: %s %s %s\nYour answer: "
                    .formatted(firstNumber, sign, secondNumber);
            var expectedValue = calculate(sign, firstNumber, secondNumber);

            quizEntries[i] = new QuizEntryInteger(question, expectedValue);
        }

        engine.check(quizEntries);
    }

    private static int calculate(Character sign, int firstNumber, int secondNumber) {
        if (sign.equals('-')) {
            return firstNumber - secondNumber;
        }

        if (sign.equals('+')) {
            return firstNumber + secondNumber;
        }

        if (sign.equals('*')) {
            return firstNumber * secondNumber;
        }

        return 0;
    }
}
