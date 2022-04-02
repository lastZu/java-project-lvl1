package hexlet.code.games;

import hexlet.code.RoundData;
import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.StringJoiner;

public final class Progression {
    private static final int ROW_LENGTH = 8;
    private static final int MAX_STEP_VALUE = 20;
    private static final String SEPARATOR = " ";
    private static final String DESCRIPTION = "What number is missing in the progression?";

    public static void run() {
        RoundData[] roundsData = new RoundData[Engine.ROUND_AMOUNT];

        for (int i = 0; i < Engine.ROUND_AMOUNT; i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(roundsData, DESCRIPTION);
    }

    private static RoundData generateRoundData() {
        int step = Utils.getRandomInteger(0, MAX_STEP_VALUE);
        int startValue = Utils.getRandomInteger(0, MAX_STEP_VALUE);
        int hiddenNumberIndex = Utils.getRandomInteger(0, ROW_LENGTH);

        int[] sequence = Utils.getArithmeticSequence(startValue, step, ROW_LENGTH);

        StringJoiner question = new StringJoiner(SEPARATOR);
        for (int j = 0; j < ROW_LENGTH; j++) {
            String tempValue = j == hiddenNumberIndex ? ".." : Integer.toString(sequence[j]);
            question.add(tempValue);
        }
        String answer = Integer.toString(sequence[hiddenNumberIndex]);

        return new RoundData(question.toString(), answer);
    }
}
