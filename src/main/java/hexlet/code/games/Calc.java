package hexlet.code.games;

import hexlet.code.RoundData;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc {
    private static final int MAX_QUESTION_VALUE = 100;
    private static final int OPERATION_AMOUNT = 3;
    private static final String DESCRIPTION = "What is the result of the expression?";

    public static void run() {
        RoundData[] roundsData = new RoundData[Engine.ROUND_AMOUNT];

        for (int i = 0; i < Engine.ROUND_AMOUNT; i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(roundsData, DESCRIPTION);
    }

    private static RoundData generateRoundData() {
        int firstRandomNumber = Utils.getRandomInteger(0, MAX_QUESTION_VALUE);
        int secondRandomNumber = Utils.getRandomInteger(0, MAX_QUESTION_VALUE);
        int operationNumber = Utils.getRandomInteger(0, OPERATION_AMOUNT);

        char[] usedOperation = {'+', '-', '*'};
        return Utils.calculate(firstRandomNumber, secondRandomNumber, usedOperation[operationNumber]);
    }
}
