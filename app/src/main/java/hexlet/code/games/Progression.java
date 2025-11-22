package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntry;

import java.util.Random;

public class Progression {
    public static void play() {
        final var maxRandomNumber = 100;
        var random = new Random();
        var quizEntries = new QuizEntry[Engine.ROUNDS];
        final var progressionSize = 5;

        for (int i = 0; i < Engine.ROUNDS; i++) {
            var missedIndex = random.nextInt(progressionSize);
            var interval = random.nextInt(maxRandomNumber) + 1;
            var startValue = random.nextInt(maxRandomNumber) + 1;
            var progression = createProgression(startValue, interval, progressionSize);

            var answer = progression[missedIndex];

            progression[missedIndex] = "..";

            quizEntries[i] = new QuizEntry(String.join(" ", progression), answer);
        }

        var engine = new Engine("What number is missing in the progression?", quizEntries);

        engine.check();
    }


    private static String[] createProgression(int startValue, int interval, int progressionSize) {
        var progression = new String[progressionSize];

        for (int i = 0; i < progressionSize; i++) {
            progression[i] = String.valueOf(startValue + i * interval);
        }

        return progression;
    }

}
