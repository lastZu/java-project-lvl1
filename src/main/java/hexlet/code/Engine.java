package hexlet.code;

import java.util.Locale;
import java.util.Scanner;

public final class Engine {
    private static final int ROUND_AMOUNT = 3;
    private static int currentRound;
    private static String userName;

    public static String greet() {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        return askNameAndSayHelloTo();
    }

    private static String askNameAndSayHelloTo() {
        System.out.print("May I have your name? ");
        Scanner scan = new Scanner(System.in);
        var name = scan.nextLine().trim();
        System.out.println("Hello, " + name + "!");

        return name;
    }

    public static boolean run(Data roundData, String description) {
        if (currentRound == ROUND_AMOUNT) {
            sayResult();
            setCurrentRound(0);
            setUserName("");
            return false;
        }
        if (currentRound == 0) {
            setUserName(greet());
            System.out.println(description);
        }
        setCurrentRound(currentRound + 1);

        return runRound(roundData);
    }

    private static boolean runRound(Data roundData) {
        String question = roundData.getQuestion();
        String correctAnswer = roundData.getAnswer();

        askCurrentQuestion(question);

        String userAnswer = getUserAnswer();

        boolean isCorrectAnswer = userAnswer.toLowerCase(Locale.ROOT).equals(correctAnswer);

        if (!isCorrectAnswer) {
            sayWrong(userAnswer, correctAnswer);
            return false;
        }
        sayCorrect();
        return true;
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

    private static void sayResult() {
        System.out.println("Congratulations, " + userName + "!");
    }

    public static void askCurrentQuestion(String questionsText) {
        System.out.println("Question: " + questionsText);
    }

    private static void setCurrentRound(int roundNumber) {
        Engine.currentRound = roundNumber;
    }

    private static void setUserName(String name) {
        Engine.userName = name;
    }
}
