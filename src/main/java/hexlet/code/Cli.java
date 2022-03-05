package hexlet.code;

import java.util.Scanner;

public class Cli {
  public static void welcomeToTheBrainGames() {
    System.out.println("Welcome to the Brain Games!");
    askNameAndSayHelloTo();
  }

  private static void askNameAndSayHelloTo() {
    System.out.print("May I have your name? ");
    Scanner scan = new Scanner(System.in);
    var name = scan.nextLine().trim();
    System.out.println("Hello, " + name + "!");
  }
}
