package hexlet.code.games;

import hexlet.code.RoundData;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Progression {
    private static final int ROW_LENGTH = 8;
    private static final int MAX_STEP_VALUE = 20;
    private static final String SEPARATOR = " ";

    public static void run() {
        String description = getDescription();
        RoundData[] roundsData = getRounds();

        Engine.run(roundsData, description);
    }

    private static String getDescription() {
        return "What number is missing in the progression?";
    }

    private static RoundData[] getRounds() {
        RoundData[] roundsData = new RoundData[Engine.ROUND_AMOUNT];

        for (int i = 0; i < Engine.ROUND_AMOUNT; i++) {
            int step = Utils.getRandomInteger(0, MAX_STEP_VALUE);
            int startValue = Utils.getRandomInteger(0, MAX_STEP_VALUE);
            int hiddenNumberIndex = Utils.getRandomInteger(0, ROW_LENGTH);

            String[] question = new String[ROW_LENGTH];
            for (int j = 0; j < ROW_LENGTH; j++) {
                int tempNumber = startValue + (j + 1) * step;
                question[j] = Integer.toString(tempNumber);
            }

            String answer = question[hiddenNumberIndex];
            question[hiddenNumberIndex] = "..";

            String textQuestion = String.join(SEPARATOR, question);
            roundsData[i] = new RoundData(textQuestion, answer);
        }

        return roundsData;
    }
}
