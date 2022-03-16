package hexlet.code.comands.games;

public final class Calc extends Engine {
    private static final int MAX_QUESTION_VALUE = 100;
    private static final int OPERATION_AMOUNT = 3;

    @Override
    public String toString() {
        return "Calc";
    }

    @Override
    protected void sayRules() {
        System.out.println("What is the result of the expression?");
    }

    @Override
    protected String askNextQuestion() {
        int firstRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);
        int secondRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);
        int operationNumber = (int) (Math.random() * OPERATION_AMOUNT);

        return printQuestion(firstRandomNumber, secondRandomNumber, operationNumber);
    }

    private String printQuestion(int x, int y, int operationNumber) {
        if (operationNumber == 0) {
            currentQuestion(x + " + " + y);
            return Integer.toString(x + y);
        }
        if (operationNumber == 1) {
            currentQuestion(x + " - " + y);
            return Integer.toString(x - y);
        }
        currentQuestion(x + " * " + y);
        return Integer.toString(x * y);
    }
}
