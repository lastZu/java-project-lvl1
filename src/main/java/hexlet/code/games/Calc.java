package hexlet.code.games;

import hexlet.code.Data;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Calc {
    private static final int MAX_QUESTION_VALUE = 100;
    private static final int OPERATION_AMOUNT = 3;

    public static void run() {
        String description = getDescription();

        boolean continueGame = true;
        while (continueGame) {
            Data roundData = getNextRound();
            continueGame = Engine.run(roundData, description);
        }
    }

    private static String getDescription() {
        return "What is the result of the expression?";
    }

    private static Data getNextRound() {
        int firstRandomNumber = Utils.getRandomInteger(0, MAX_QUESTION_VALUE);
        int secondRandomNumber = Utils.getRandomInteger(0, MAX_QUESTION_VALUE);
        int operationNumber = Utils.getRandomInteger(0, OPERATION_AMOUNT);

        return generateNextRound(firstRandomNumber, secondRandomNumber, operationNumber);
    }

    private static Data generateNextRound(int x, int y, int operationNumber) {
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

        return new Data(question, Integer.toString(answer));
    }
}
