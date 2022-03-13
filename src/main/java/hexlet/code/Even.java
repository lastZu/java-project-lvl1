package hexlet.code;

import java.util.Locale;
import java.util.Scanner;

public final class Even implements Command {
    private static final int MAX_QUESTION_VALUE = 10000;
    private static final int QUESTION_AMOUNT = 3;
    private String userName;

    @Override
    public String toString() {
        return "Even";
    }

    @Override
    public boolean run() {
        setUserName(Cli.welcomeToTheBrainGames());

        sayRules();

        runPlay();

        return true;
    }

    private void sayRules() {
        System.out.println("Answer 'yes' if number even otherwise answer 'no'.");
    }

    private void sayCorrect() {
        System.out.println("Correct!");
    }

    private void sayWrong(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + getUserName() + "!");
    }

    private void sayResult() {
        System.out.println("Congratulations, " + getUserName() + "!");
    }

    private void runPlay() {
        for (int i = 0; i < QUESTION_AMOUNT; i++) {
            int number = nextQuestion();
            String answer = getUserAnswer();

            boolean isEvenQuestion = number % 2 == 0;

            boolean isCorrectAnswer = answer.toLowerCase(Locale.ROOT).equals("yes")
                                    || answer.toLowerCase(Locale.ROOT).equals("no");

            boolean isEvenAnswer = answer.toLowerCase(Locale.ROOT).equals("yes");

            if (!isCorrectAnswer || isEvenAnswer != isEvenQuestion) {
                var correctAnswer = isEvenQuestion ? "yes" : "no";
                sayWrong(answer, correctAnswer);
                return;
            }
            sayCorrect();
        }
        sayResult();
    }

    private int nextQuestion() {
        int rundomNumber = (int) (Math.random() * MAX_QUESTION_VALUE);

        System.out.println("Question: " + rundomNumber);
        return rundomNumber;
    }

    private String getUserAnswer() {
        System.out.print("Your answer: ");
        Scanner scan = new Scanner(System.in);

        return scan.nextLine().trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String name) {
        this.userName = name;
    }
}
