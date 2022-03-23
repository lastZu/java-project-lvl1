package hexlet.code.games;

import hexlet.code.Engine;

public final class Calc {
    private static final int MAX_QUESTION_VALUE = 100;
    private static final int OPERATION_AMOUNT = 3;

    public static void run() {
        String description = getDescription();

        boolean continueGame = true;
        while (continueGame) {
            String[] roundData = getNextQuestion();
            continueGame = Engine.run(roundData, description);
        }
    }

    private static String getDescription() {
        return "What is the result of the expression?";
    }

    public static String[] getNextQuestion() {
        int firstRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);
        int secondRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);
        int operationNumber = (int) (Math.random() * OPERATION_AMOUNT);

        String[] roundData = printQuestion(firstRandomNumber, secondRandomNumber, operationNumber);

        return roundData;
    }

    public static String askNextQuestion(int questionNumber) {
        if (questionNumber == 0) {
            sayRules();
        }
        int firstRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);
        int secondRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);
        int operationNumber = (int) (Math.random() * OPERATION_AMOUNT);

        return printQuestion(firstRandomNumber, secondRandomNumber, operationNumber);
    }

    private static String[] printQuestion(int x, int y, int operationNumber) {
        String[] roundData = new String[2];

        if (operationNumber == 0) {
            roundData[0] = x + y;
            roundData[1] = Integer.toString(x + y);
        } else if (operationNumber == 1) {
            return Integer.toString(x - y);
        } else if (operationNumber == 1) {
            return Integer.toString(x * y);
        }
    }
}
