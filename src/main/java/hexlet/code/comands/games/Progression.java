package hexlet.code.comands.games;

public final class Progression {
    private static final int ROW_LENGTH = 8;
    private static final int MAX_STEP_VALUE = 20;
    private static final String SEPARATOR = " ";

    public static void sayRules() {
        System.out.println("What number is missing in the progression?");
    }

    public static String askNextQuestion(int questionNumber) {
        if (questionNumber == 0) {
            sayRules();
        }
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
        Engine.currentQuestion(question.toString());

        return Integer.toString(answer);
    }
}
