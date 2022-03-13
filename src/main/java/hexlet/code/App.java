package hexlet.code;

import java.util.Scanner;

public class App {
    private static final int NUMBER_OF_COMMANDS_DISPLAYED = 3;

    public static void main(String[] args) {
        Command[] commands = getCommands();

        boolean nextCommand = true;
        while (nextCommand) {
            Command command = askNextCommand(commands);
            nextCommand = command.run();
        }

        System.exit(0);
    }

    private static Command[] getCommands() {
        Command[] commands = new Command[NUMBER_OF_COMMANDS_DISPLAYED];

        commands[0] = new Exit();
        commands[1] = new Greet();
        commands[2] = new Even();

        return commands;
    }

    private static void printCommandToMenu(Command command, int index) {
        System.out.println(index + " - " + command.toString());
    }

    private static Command askNextCommand(Command[] commands) {
        int length = commands.length;
        for (int i = 1; i < length; i++) {
            printCommandToMenu(commands[i], i);
        }
        printCommandToMenu(commands[0], 0);

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

        return commands[commandNumber];
    }
}
