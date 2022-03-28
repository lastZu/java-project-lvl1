package hexlet.code.games;

import hexlet.code.RoundData;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime {
    private static final int MAX_QUESTION_VALUE = 1000;

    public static void run() {
        String description = getDescription();
        RoundData[] roundData = getNextRound();

        Engine.run(roundData, description);
    }

    private static String getDescription() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    private static RoundData[] getNextRound() {
        RoundData[] roundsData = new RoundData[Engine.ROUND_AMOUNT];

        for (int i = 0; i < Engine.ROUND_AMOUNT; i++) {
            int randomNumber = Utils.getRandomInteger(1, MAX_QUESTION_VALUE);

            String question = Integer.toString(randomNumber);
            String answer = getAnswer(randomNumber);

            roundsData[i] = new RoundData(question, answer);
        }

        return roundsData;
    }

    private static String getAnswer(int randomNumber) {
        if (randomNumber == 1) {
            return "no";
        }
        for (int i = 2; i * i <= randomNumber; i++) {
            if (randomNumber % i == 0) {
                return "no";
            }
        }
        return "yes";
    }
}
