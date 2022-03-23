package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        printCommands();
        int maxCommandNumber = 6;
        int numberPickedCommand = askNextCommand(maxCommandNumber);
        runCommand(numberPickedCommand);

        System.exit(0);
    }

    private static void printCommands() {
        printCommandToMenu("Exit", 0);
        printCommandToMenu("Greet", 1);
        printCommandToMenu("Even", 2);
        printCommandToMenu("Calc", 3);
        printCommandToMenu("GCD", 4);
        printCommandToMenu("Progression", 5);
        printCommandToMenu("Prime", 6);
    }

    private static int askNextCommand(int maxCommandNumber) {
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

        return commandNumber;
    }

    private static void printCommandToMenu(String command, int index) {
        System.out.println(index + " - " + command);
    }

    private static void runCommand(int commandNumber) {
        switch (commandNumber) {
            case 1 -> Cli.greet();
            case 2 -> Even.run();
            case 3 -> Calc.run();
            case 2 -> GCD.run();
            case 2 -> Progression.run();
            case 2 -> Prime.run();
            default -> {}
        }
    }
}
