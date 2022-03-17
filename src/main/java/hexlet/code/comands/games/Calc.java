package hexlet.code.comands.games;

public final class Calc {
    private static final int MAX_QUESTION_VALUE = 100;
    private static final int OPERATION_AMOUNT = 3;

    public static void sayRules() {
        System.out.println("What is the result of the expression?");
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

    private static String printQuestion(int x, int y, int operationNumber) {
        if (operationNumber == 0) {
            Engine.currentQuestion(x + " + " + y);
            return Integer.toString(x + y);
        }
        if (operationNumber == 1) {
            Engine.currentQuestion(x + " - " + y);
            return Integer.toString(x - y);
        }
        Engine.currentQuestion(x + " * " + y);
        return Integer.toString(x * y);
    }
}
