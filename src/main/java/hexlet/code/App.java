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
        printCommands();
        String numberPickedCommand = askNextCommand(MAX_COMMAND_NUMBER);
        runCommand(numberPickedCommand);

        System.exit(0);
    }

    private static void printCommands() {
        printCommandToMenu("Greet", "1");
        printCommandToMenu("Even", "2");
        printCommandToMenu("Calc", "3");
        printCommandToMenu("GCD", "4");
        printCommandToMenu("Progression", "5");
        printCommandToMenu("Prime", "6");
        printCommandToMenu("Exit", "0");
    }

    private static String askNextCommand(int maxCommandNumber) {
        System.out.print("Your choice: ");
        Scanner scan = new Scanner(System.in);
        int commandNumber = -1;
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                commandNumber = scan.nextInt();
            }
            if (commandNumber >= 0 && commandNumber < maxCommandNumber + 1) {
                break;
            }
            scan.next();
        }

        return Integer.toString(commandNumber);
    }

    private static void printCommandToMenu(String command, String index) {
        System.out.println(index + " - " + command);
    }

    private static void runCommand(String commandNumber) {
        switch (commandNumber) {
            case "1" -> Cli.greet();
            case "2" -> Even.run();
            case "3" -> Calc.run();
            case "4" -> GCD.run();
            case "5" -> Progression.run();
            case "6" -> Prime.run();
            default -> { }
        }
    }
}
