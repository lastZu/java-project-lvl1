package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    private static final int MAX_COMMAND_NUMBER = 6;

    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");

        printCommandToMenu("Greet", "1");
        printCommandToMenu("Even", "2");
        printCommandToMenu("Calc", "3");
        printCommandToMenu("GCD", "4");
        printCommandToMenu("Progression", "5");
        printCommandToMenu("Prime", "6");
        printCommandToMenu("Exit", "0");

        System.out.print("Your choice: ");
        String userChoice = "";
        Scanner scan = new Scanner(System.in);
        if (scan.hasNext()) {
            userChoice = scan.next();
        }

        switch (userChoice) {
            case "1" -> Engine.greet();
            case "2" -> Even.run();
            case "3" -> Calc.run();
            case "4" -> GCD.run();
            case "5" -> Progression.run();
            case "6" -> Prime.run();
            default -> { }
        }
    }

    private static void printCommandToMenu(String command, String index) {
        System.out.println(index + " - " + command);
    }
}
