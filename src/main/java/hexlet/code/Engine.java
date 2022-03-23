package hexlet.code;

import hexlet.code.Cli;

import java.util.Locale;
import java.util.Scanner;

public final class Engine {
    private static final int ROUND_AMOUNT = 3;
    private static int currentRound = 0;
    private static String userName;

    public static String[] initializeData() {
        
    }

    public static boolean run(String[] roundData, String description) {
        int currentRound = getCurrentRound();
        if (currentRound == ROUND_AMOUNT) {
            sayResult();
            setCurrentRound(0);
            setUserName("");
            return false;
        }
        if (currentRound == 0) {
            setUserName(Cli.greet());
            System.out.println(description);
        }
        setCurrentRound(currentRound + 1);

        runRound(roundData);

        return true;
    }

    private static void runRound(String[] roundData) {
        String question = roundData[0];
        String correctAnswer = roundData[1];

        System.out.println(question);

        String userAnswer = getUserAnswer();

        boolean isCorrectAnswer = userAnswer.toLowerCase(Locale.ROOT).equals(correctAnswer);

        if (!isCorrectAnswer) {
            sayWrong(userAnswer, correctAnswer);
            return;
        }
        sayCorrect();
    }

    private static String getUserAnswer() {
        System.out.print("Your answer: ");
        Scanner scan = new Scanner(System.in);

        return scan.nextLine().trim();
    }

    private static void sayCorrect() {
        System.out.println("Correct!");
    }

    private static void sayWrong(String userAnswer, String correctAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was '" + correctAnswer + "'.");
        System.out.println("Let's try again, " + getUserName() + "!");
    }

    private static String getUserName() {
        return userName;
    }

    private static void sayResult(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void currentQuestion(String questionsText) {
        System.out.println("Question: " + questionsText);
    }

    public static int getCurrentRound() {
        return currentRound;
    }

    public static void setCurrentRound(int currentRound) {
        Engine.currentRound = currentRound;
    }

    public static void setUserName(String userName) {
        Engine.userName = userName;
    }
}
