package hexlet.code;

import java.util.Locale;
import java.util.Scanner;

abstract class Engine implements Command {
    private static final int QUESTION_AMOUNT = 3;
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String name) {
        this.userName = name;
    }

    @Override
    public boolean run() {
        setUserName(Cli.welcomeToTheBrainGames());

        sayRules();

        runPlay();

        return true;
    }

    protected abstract void sayRules();

    private void runPlay() {
        for (int i = 0; i < QUESTION_AMOUNT; i++) {
            String correctAnswer = askNextQuestion();
            String userAnswer = getUserAnswer();

            boolean isCorrectAnswer = userAnswer.toLowerCase(Locale.ROOT).equals(correctAnswer);

            if (!isCorrectAnswer) {
                sayWrong(userAnswer, correctAnswer);
                return;
            }
            sayCorrect();
        }
        sayResult();
    }

    protected abstract String askNextQuestion();

    private String getUserAnswer() {
        System.out.print("Your answer: ");
        Scanner scan = new Scanner(System.in);

        return scan.nextLine().trim();
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
}
