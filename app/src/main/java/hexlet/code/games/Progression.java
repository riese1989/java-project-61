package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryInteger;

import java.util.Random;

public class Progression {
    private static final int PROGRESSION_SIZE = 5;

    public static void play() {
        final var quizEntriesCount = 3;
        final var maxRandomNumber = 100;
        var random = new Random();
        var quizEntries = new QuizEntryInteger[quizEntriesCount];

        for (int i = 0; i < Engine.ROUNDS; i++) {
            var missedIndex = random.nextInt(PROGRESSION_SIZE);
            var interval = random.nextInt(maxRandomNumber) + 1;
            var startValue = random.nextInt(maxRandomNumber) + 1;
            var progression = createProgression(startValue, interval);
            var stringProgression = new StringBuilder();

            for (int j = 0; j < PROGRESSION_SIZE; j++) {
                if (j != missedIndex) {
                    stringProgression.append(progression[j]).append(" ");
                } else {
                    stringProgression.append(".. ");
                }
            }

            quizEntries[i] = new QuizEntryInteger(stringProgression.toString(),
                    Integer.parseInt(progression[missedIndex]));
        }

        var engine = new Engine("What number is missing in the progression?", quizEntries);

        engine.checkInteger();
    }


    private static String[] createProgression(int startValue, int interval) {
        var progression = new String[PROGRESSION_SIZE];

        for (int i = 0; i < PROGRESSION_SIZE; i++) {
            progression[i] = String.valueOf(startValue + i * interval);
        }

        return progression;
    }

}
