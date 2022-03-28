package hexlet.code.games;

import hexlet.code.RoundData;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class GCD {
    private static final int MAX_QUESTION_VALUE = 1000;

    public static void run() {
        String description = getDescription();
        RoundData[] roundData = getNextRound();

        Engine.run(roundData, description);
    }

    private static String getDescription() {
        return "Find the greatest common divisor of given numbers.";
    }

    private static RoundData[] getNextRound() {
        RoundData[] roundsData = new RoundData[Engine.ROUND_AMOUNT];

        for (int i = 0; i < Engine.ROUND_AMOUNT; i++) {
            int firstRandomNumber = Utils.getRandomInteger(1, MAX_QUESTION_VALUE);
            int secondRandomNumber = Utils.getRandomInteger(1, MAX_QUESTION_VALUE);

            String question = firstRandomNumber + " " + secondRandomNumber;
            String answer = Integer.toString(getAnswer(firstRandomNumber, secondRandomNumber));

            roundsData[i] = new RoundData(question, answer);
        }

        return roundsData;
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
