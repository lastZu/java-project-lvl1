package hexlet.code;

public final class Progression extends Engine {
    private static final int ROW_LENGTH = 8;
    private static final int MAX_STEP_VALUE = 20;
    private static final String SEPARATOR = " ";

    @Override
    public String toString() {
        return "Progression";
    }

    @Override
    protected void sayRules() {
        System.out.println("What number is missing in the progression?");
    }

    @Override
    protected String askNextQuestion() {
        int step = (int) (Math.random() * MAX_STEP_VALUE);
        int startValue = (int) (Math.random() * MAX_STEP_VALUE);
        int hiddenNumberIndex = (int) (Math.random() * ROW_LENGTH) + 1;

        int answer = 0;
        StringBuilder question = new StringBuilder();
        for (int i = 1; i <= ROW_LENGTH; i++) {
            int tempNumber = startValue + i * step;
            if (i == hiddenNumberIndex) {
                question.append("..");
                answer = tempNumber;
            } else {
                question.append(tempNumber);
            }
            if (i != ROW_LENGTH) {
                question.append(SEPARATOR);
            }
        }
        currentQuestion(question.toString());

        return Integer.toString(answer);
    }
}
