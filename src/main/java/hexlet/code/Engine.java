package hexlet.code;

import java.util.Locale;
import java.util.Scanner;

public final class Engine {
    public static final int ROUND_AMOUNT = 3;

    public static void greet() {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
    }

    public static void run(RoundData[] roundData, String description) {
        greet();

        System.out.print("May I have your name? ");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine().trim();
        System.out.println("Hello, " + userName + "!");

        System.out.println(description);

        boolean isCorrectAnswer = false;
        for (int i = 0; i < ROUND_AMOUNT; i++) {
            String question = roundData[i].getQuestion();
            String correctAnswer = roundData[i].getAnswer();

            System.out.println("Question: " + question);

            System.out.print("Your answer: ");
            String userAnswer = "";
            if (scan.hasNextLine()) {
                userAnswer = scan.nextLine().trim();
            }

            isCorrectAnswer = userAnswer.toLowerCase(Locale.ROOT).equals(correctAnswer);
            if (!isCorrectAnswer) {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", userAnswer, correctAnswer);
                System.out.println("Let's try again, " + userName + "!");
                return;
            }

            System.out.println("Correct!");
        }

        System.out.println("Congratulations, " + userName + "!");
    }
}
