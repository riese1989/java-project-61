package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryInteger;

import java.util.List;
import java.util.Random;

public class Calc {
    public static void play() {
        var random = new Random();
        var signList = List.of('-', '+', '*');
        var engine = new Engine("What is the result of the expression?");
        var quizEntries = new QuizEntryInteger[3];

        for (int i = 0; i < 3; i++) {
            int firstNumber = random.nextInt(100) + 1;
            int secondNumber = random.nextInt(100) + 1;
            var index = random.nextInt(2) + 1;
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
