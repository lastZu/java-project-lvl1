package hexlet.code.comands.games;

public final class GCD {
    private static final int MAX_QUESTION_VALUE = 1000;

    public static void sayRules() {
        System.out.println("Find the greatest common divisor of given numbers.");
    }

    public static String askNextQuestion(int questionNumber) {
        if (questionNumber == 0) {
            sayRules();
        }
        int firstRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE) + 1;
        int secondRandomNumber = (int) (Math.random() * MAX_QUESTION_VALUE) + 1;

        Engine.currentQuestion(firstRandomNumber + " " + secondRandomNumber);
        return Integer.toString(getAnswer(firstRandomNumber, secondRandomNumber));
    }

    private static int getAnswer(int bigNumber, int smallNumber) {
        if (bigNumber < smallNumber) {
            return getAnswer(smallNumber, bigNumber);
        }
        if (bigNumber % smallNumber == 0) {
            return smallNumber;
        }
        return getAnswer(smallNumber, bigNumber % smallNumber);
    }
}
