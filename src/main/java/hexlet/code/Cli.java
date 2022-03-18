package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String welcomeToTheBrainGames() {
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
}
