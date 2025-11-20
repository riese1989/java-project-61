package hexlet.code.games;

import hexlet.code.engine.Engine;
import hexlet.code.entities.QuizEntryInteger;

import java.util.Random;

public class Progression {
    private static final int QUIZ_ENTRIES_COUNT = 3;
    private static final int MAX_RANDOM_NUMBER  = 100;

    public static void play() {
        var random = new Random();
        var engine = new Engine("What number is missing in the progression?");
        var quizEntries = new QuizEntryInteger[QUIZ_ENTRIES_COUNT];

        for (int i = 0; i < 3; i++) {
            var missedIndex = random.nextInt(5);
            var interval = random.nextInt(MAX_RANDOM_NUMBER) + 1;
            var startValue = random.nextInt(MAX_RANDOM_NUMBER) + 1;
            var progression = createProgression(startValue, interval);
            var stringProgression = new StringBuilder();

            for (int j = 0; j < 5; j++) {
                if (j != missedIndex) {
                    stringProgression.append(progression[j]).append(" ");
                } else {
                    stringProgression.append(".. ");
                }
            }

            var question = "Question: %s\nYour answer: ".formatted(stringProgression);
            
            quizEntries[i] = new QuizEntryInteger(question, Integer.parseInt(progression[missedIndex]));
        }

        engine.check(quizEntries);
    }


    private static String[] createProgression(int startValue, int interval) {
        var progression = new String[5];

        for (int i = 0; i < 5; i++) {
            progression[i] = String.valueOf(startValue + i * interval);
        }

        return progression;
    }

}
