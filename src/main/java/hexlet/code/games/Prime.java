package hexlet.code.games;

public final class Prime {
    private static final int MAX_QUESTION_VALUE = 1000;

    public static void sayRules() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    public static String askNextQuestion(int questionNumber) {
        if (questionNumber == 0) {
            sayRules();
        }
        int randomNumber = (int) (Math.random() * MAX_QUESTION_VALUE) + 1;

        Engine.currentQuestion(Integer.toString(randomNumber));
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
