package hexlet.code;

import hexlet.code.comands.Exit;
import hexlet.code.comands.games.Engine;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<String> commands = getCommands();

        boolean haveNextCommand = true;
        while (haveNextCommand) {
            String command = askNextCommand(commands);
            haveNextCommand = runCommand(command);
        }

        System.exit(0);
    }

    private static boolean runCommand(String command) {
        if (command.equals("Exit")) {
            return Exit.run();
        }
        return Engine.run(command);
    }

    private static ArrayList<String> getCommands() {
        ArrayList<String> commands = new ArrayList<>();

        commands.add("Exit");
        commands.add("Greet");
        commands.add("Even");
        commands.add("Calc");
        commands.add("GCD");
        commands.add("Progression");
        commands.add("Prime");

        return commands;
    }

    private static void printCommandToMenu(String command, int index) {
        System.out.println(index + " - " + command);
    }

    private static String askNextCommand(ArrayList<String> commands) {
        System.out.println("Please enter the game number and press Enter.");

        int length = commands.size();
        for (int i = 1; i < length; i++) {
            printCommandToMenu(commands.get(i), i);
        }
        printCommandToMenu(commands.get(0), 0);

        System.out.print("Your choice: ");
        Scanner scan = new Scanner(System.in);
        int commandNumber = -1;
        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                commandNumber = scan.nextInt();
            }
            if (commandNumber >= 0 && commandNumber < length) {
                break;
            }
            scan.next();
        }

        return commands.get(commandNumber);
    }
}
