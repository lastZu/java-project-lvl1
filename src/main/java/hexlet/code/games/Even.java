package hexlet.code.games;

import hexlet.code.Data;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Even {
    private static final int MAX_QUESTION_VALUE = 10000;

    public static void run() {
        String description = getDescription();

        boolean continueGame = true;
        while (continueGame) {
            Data roundData = getNextRound();
            continueGame = Engine.run(roundData, description);
        }
    }

    private static String getDescription() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }

    private static Data getNextRound() {
        int randomNumber = Utils.getRandomInteger(0, MAX_QUESTION_VALUE);

        String question = Integer.toString(randomNumber);
        String answer = randomNumber % 2 == 0 ? "yes" : "no";

        return new Data(question, answer);
    }
}
