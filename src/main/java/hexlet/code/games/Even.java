package hexlet.code.games;

import hexlet.code.Engine;

public final class Even {
    private static final int MAX_QUESTION_VALUE = 10000;

    public static void run() {
        String description = getDescription();

        boolean continueGame = true;
        while (continueGame) {
            String[] roundData = getNextQuestion();
            continueGame = Engine.run(roundData, description);
        }
    }

    private static String getDescription() {
        return "Answer 'yes' if number even otherwise answer 'no'.";
    }

    public static String[] getNextQuestion() {
        int randomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);

        String[] roundData = new String[2];
        roundData[0] = Integer.toString(randomNumber);
        roundData[1] = randomNumber % 2 == 0 ? "yes" : "no";
        return roundData;
    }
}
