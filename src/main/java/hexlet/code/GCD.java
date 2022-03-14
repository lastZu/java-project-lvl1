package hexlet.code;

public final class GCD extends Engine {
    private static final int MAX_QUESTION_VALUE = 1000;

    @Override
    public String toString() {
        return "GCD";
    }

    @Override
    protected void sayRules() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    @Override
    protected String askNextQuestion() {
        int firstRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);
        int secondRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);

        currentQuestion(firstRandomNumber + " " + secondRandomNumber);
        return Integer.toString(getAnswer(firstRandomNumber, secondRandomNumber));
    }

    private int getAnswer(int bigNumber, int smallNumber) {
        if (bigNumber < smallNumber) {
            return getAnswer(smallNumber, bigNumber);
        }
        if (bigNumber % smallNumber == 0) {
            return smallNumber;
        }
        return getAnswer(smallNumber, bigNumber % smallNumber);
    }
}
