package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryInteger;

import java.util.List;
import java.util.Random;

public class Calc {
    public static void play() {
        final var quizEntriesCount = 3;
        final var maxRandomIndex = 2;
        final var maxRandomNumber = 100;
        var random = new Random();
        var signList = List.of('-', '+', '*');
        var quizEntries = new QuizEntryInteger[quizEntriesCount];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            int firstNumber = random.nextInt(maxRandomNumber) + 1;
            int secondNumber = random.nextInt(maxRandomNumber) + 1;
            var index = random.nextInt(maxRandomIndex) + 1;
            var sign = signList.get(index);
            var expression = firstNumber + " " + sign + " " + secondNumber;
            var expectedValue = calculate(sign, firstNumber, secondNumber);

            quizEntries[i] = new QuizEntryInteger(expression, expectedValue);
        }

        var engine = new Engine("What is the result of the expression?", quizEntries);

        engine.checkInteger();
    }

    private static int calculate(Character sign, int firstNumber, int secondNumber) {
        return  switch (sign) {
            case '-' -> firstNumber - secondNumber;
            case '+' -> firstNumber + secondNumber;
            case '*' -> firstNumber * secondNumber;
            default -> 0;
        };
    }
}
