package hexlet.code.games;

import hexlet.code.Data;
import hexlet.code.Engine;
import hexlet.code.Utils;

public final class Prime {
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
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    private static Data getNextRound() {
        int randomNumber = Utils.getRandomInteger(1, MAX_QUESTION_VALUE);

        String question = Integer.toString(randomNumber);
        String answer = getAnswer(randomNumber);

        return new Data(question, answer);
    }

    public static String getAnswer(int randomNumber) {
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
