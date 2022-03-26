package hexlet.code.games;

import hexlet.code.Data;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.StringJoiner;

public final class Progression {
    private static final int ROW_LENGTH = 8;
    private static final int MAX_STEP_VALUE = 20;
    private static final String SEPARATOR = " ";

    public static void run() {
        String description = getDescription();

        boolean continueGame = true;
        while (continueGame) {
            Data roundData = getNextRound();
            continueGame = Engine.run(roundData, description);
        }
    }

    private static String getDescription() {
        return "What number is missing in the progression?";
    }

    private static Data getNextRound() {
        int step = Utils.getRandomInteger(0, MAX_STEP_VALUE);
        int startValue = Utils.getRandomInteger(0, MAX_STEP_VALUE);
        int hiddenNumberIndex = Utils.getRandomInteger(1, ROW_LENGTH);

        return generateNextRound(startValue, step, hiddenNumberIndex);
    }

    private static Data generateNextRound(int startValue, int step, int hiddenNumberIndex) {
        int answer = 0;
        StringJoiner question = new StringJoiner(SEPARATOR);
        for (int i = 1; i <= ROW_LENGTH; i++) {
            int tempNumber = startValue + i * step;
            if (i == hiddenNumberIndex) {
                question.add("..");
                answer = tempNumber;
            } else {
                question.add(Integer.toString(tempNumber));
            }
        }

        return new Data(question.toString(), Integer.toString(answer));
    }
}
