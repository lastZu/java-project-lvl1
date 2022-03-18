package hexlet.code.comands.games;

import hexlet.code.Cli;
import java.util.Locale;
import java.util.Scanner;

public final class Engine {
    private static final int QUESTION_AMOUNT = 3;

    public static boolean run(String game) {
        String userName = Cli.welcomeToTheBrainGames();

        runPlay(userName, game);

        return false;
    }

    private static void runPlay(String userName, String game) {
        for (int i = 0; i < QUESTION_AMOUNT; i++) {
            String correctAnswer = askNextQuestion(game, i);
            if (correctAnswer.isEmpty()) {
                return;
            }
            String userAnswer = getUserAnswer();

            boolean isCorrectAnswer = userAnswer.toLowerCase(Locale.ROOT).equals(correctAnswer);

            if (!isCorrectAnswer) {
                sayWrong(userName, userAnswer, correctAnswer);
                return;
            }
            sayCorrect();
        }
        sayResult(userName);
    }

    private static String askNextQuestion(String game, int questionNumber) {
        return switch (game) {
            case "Calc" -> Calc.askNextQuestion(questionNumber);
            case "Even" -> Even.askNextQuestion(questionNumber);
            case "GCD" -> GCD.askNextQuestion(questionNumber);
            case "Prime" -> Prime.askNextQuestion(questionNumber);
            case "Progression" -> Progression.askNextQuestion(questionNumber);
            case "Greet" -> "";
            default -> "";
        };
    }

    private static String getUserAnswer() {
        System.out.print("Your answer: ");
        Scanner scan = new Scanner(System.in);

        return scan.nextLine().trim();
    }

    private static void sayCorrect() {
        System.out.println("Correct!");
    }

    private static void sayWrong(String userName, String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + userName + "!");
    }

    private static void sayResult(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void currentQuestion(String questionsText) {
        System.out.println("Question: " + questionsText);
    }
}
