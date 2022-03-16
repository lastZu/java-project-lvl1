package hexlet.code.comands.games;

public final class Even {
    private static final int MAX_QUESTION_VALUE = 10000;

    public static void sayRules() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
    }

    public static String askNextQuestion(int questionNumber) {
        if (questionNumber == 0) {
            sayRules();
        }
        int randomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);

        Engine.currentQuestion(Integer.toString(randomNumber));

        return randomNumber % 2 == 0 ? "yes" : "no";
    }
}
