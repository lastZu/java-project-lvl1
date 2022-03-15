package hexlet.code;

import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Command> commands = getCommands();

        boolean nextCommand = true;
        while (nextCommand) {
            Command command = askNextCommand(commands);
            nextCommand = command.run();
        }

        System.exit(0);
    }

    private static ArrayList<Command> getCommands() {
        ArrayList<Command> commands = new ArrayList<>();

        commands.add(new Exit());
        commands.add(new Greet());
        commands.add(new Even());
        commands.add(new Calc());
        commands.add(new GCD());
        commands.add(new Progression());
        commands.add(new Prime());

        return commands;
    }

    private static void printCommandToMenu(Command command, int index) {
        System.out.println(index + " - " + command.toString());
    }

    private static Command askNextCommand(ArrayList<Command> commands) {
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
