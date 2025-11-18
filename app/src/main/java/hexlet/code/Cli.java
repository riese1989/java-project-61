package hexlet.code;

import java.util.Scanner;

public class Cli {
    public static String greed() {
        System.out.print("Welcome to the Brain Games!\nMay I have your name? ");
        var scanner = new Scanner(System.in);
        var name = scanner.nextLine();

        System.out.printf("Hello, %s!%n", name);

        return name;
    }
}
