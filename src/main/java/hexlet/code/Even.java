package hexlet.code;

public final class Even extends Engine {
    private static final int MAX_QUESTION_VALUE = 10000;

    @Override
    public String toString() {
        return "Even";
    }

    @Override
    protected void sayRules() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
    }

    @Override
    protected String askNextQuestion() {
        int randomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);

        System.out.println("Question: " + randomNumber);

        return randomNumber % 2 == 0 ? "yes" : "no";
    }
}
