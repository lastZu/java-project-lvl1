package hexlet.code.games;

import hexlet.code.RoundData;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even {
    private static final int MAX_QUESTION_VALUE = 10000;

    public static void run() {
        String description = getDescription();
        RoundData[] roundData = getNextRound();

        Engine.run(roundData, description);
    }

    private static String getDescription() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }

    private static RoundData[] getNextRound() {
        RoundData[] roundsData = new RoundData[Engine.ROUND_AMOUNT];

        for (int i = 0; i < Engine.ROUND_AMOUNT; i++) {
            int randomNumber = Utils.getRandomInteger(1, MAX_QUESTION_VALUE);

            String question = Integer.toString(randomNumber);
            String answer = randomNumber % 2 == 0 ? "yes" : "no";

            roundsData[i] = new RoundData(question, answer);
        }

        return roundsData;
    }
}
