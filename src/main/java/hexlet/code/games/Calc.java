package hexlet.code.games;

import hexlet.code.RoundData;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc {
    private static final int MAX_QUESTION_VALUE = 100;
    private static final int OPERATION_AMOUNT = 3;

    public static void run() {
        String description = getDescription();
        RoundData[] roundData = getNextRound();

        Engine.run(roundData, description);
    }

    private static String getDescription() {
        return "What is the result of the expression?";
    }

    private static RoundData[] getNextRound() {
        RoundData[] roundsData = new RoundData[Engine.ROUND_AMOUNT];

        for (int i = 0; i < Engine.ROUND_AMOUNT; i++) {
            int firstRandomNumber = Utils.getRandomInteger(0, MAX_QUESTION_VALUE);
            int secondRandomNumber = Utils.getRandomInteger(0, MAX_QUESTION_VALUE);
            int operationNumber = Utils.getRandomInteger(0, OPERATION_AMOUNT);

            roundsData[i] = generateNextRound(firstRandomNumber, secondRandomNumber, operationNumber);
        }

        return roundsData;
    }

    private static RoundData generateNextRound(int x, int y, int operationNumber) {
        String question = "0 + 0";
        int answer = 0;

        if (operationNumber == 0) {
            answer = x + y;
            question = x + " + " + y;
        } else if (operationNumber == 1) {
            answer = x - y;
            question = x + " - " + y;
        } else if (operationNumber == 2) {
            answer = x * y;
            question = x + " * " + y;
        }

        return new RoundData(question, Integer.toString(answer));
    }
}
