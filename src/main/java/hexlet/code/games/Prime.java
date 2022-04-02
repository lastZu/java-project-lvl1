package hexlet.code.games;

import hexlet.code.RoundData;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime {
    private static final int MAX_QUESTION_VALUE = 1000;
    private static final String DESCRIPTION = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

    public static void run() {
        RoundData[] roundsData = new RoundData[Engine.ROUND_AMOUNT];

        for (int i = 0; i < Engine.ROUND_AMOUNT; i++) {
            roundsData[i] = generateRoundData();
        }

        Engine.run(roundsData, DESCRIPTION);
    }

    private static RoundData generateRoundData() {
        int randomNumber = Utils.getRandomInteger(1, MAX_QUESTION_VALUE);

        String question = Integer.toString(randomNumber);
        String answer = Utils.isPrime(randomNumber) ? "yes" : "no";

        return new RoundData(question, answer);
    }
}
