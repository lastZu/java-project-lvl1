package hexlet.code;

import java.util.Scanner;

public final class Greet {
    public static void run() {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine().trim();
        System.out.println("Hello, " + userName + "!");
    }
}
