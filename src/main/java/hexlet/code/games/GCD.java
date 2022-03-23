package hexlet.code.games;

import hexlet.code.Data;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class GCD {
    private static final int MAX_QUESTION_VALUE = 1000;

    public static void run() {
        String description = getDescription();

        boolean continueGame = true;
        while (continueGame) {
            Data roundData = getNextRound();
            continueGame = Engine.run(roundData, description);
        }
    }

    private static String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    private static Data getNextRound() {
        int firstRandomNumber = Utils.getRandomInteger(1, MAX_QUESTION_VALUE);
        int secondRandomNumber = Utils.getRandomInteger(1, MAX_QUESTION_VALUE);

        String question = firstRandomNumber + " " + secondRandomNumber;
        String answer = Integer.toString(getAnswer(firstRandomNumber, secondRandomNumber));

        return new Data(question, answer);
    }

    private static int getAnswer(int bigNumber, int smallNumber) {
        if (bigNumber < smallNumber) {
            return getAnswer(smallNumber, bigNumber);
        }
        if (bigNumber % smallNumber == 0) {
            return smallNumber;
        }
        return getAnswer(smallNumber, bigNumber % smallNumber);
    }
}
