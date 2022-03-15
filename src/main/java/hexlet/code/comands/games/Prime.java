package hexlet.code.comands.games;

public final class Prime extends Engine {
    private static final int MAX_QUESTION_VALUE = 1000;

    @Override
    public String toString() {
        return "Prime";
    }

    @Override
    protected void sayRules() {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
    }

    @Override
    protected String askNextQuestion() {
        int randomNumber = (int) (Math.random() * MAX_QUESTION_VALUE) + 1;

        currentQuestion(Integer.toString(randomNumber));
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
