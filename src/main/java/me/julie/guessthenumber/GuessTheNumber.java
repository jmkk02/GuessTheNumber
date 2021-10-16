package me.julie.guessthenumber;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class GuessTheNumber {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to Guess The Number!");
        Thread.sleep(1500);
        System.out.println("I have a number in mind. If you guess it correctly, you win!");
        Thread.sleep(1500);
        System.out.println("What is your guess? (0 - 100)");
        game();
    }

    public static void game() throws InterruptedException {
        int number = new Random().nextInt(101);
        // nextInt: "next" int of the "list" of random nums.
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int input;
            try {
                input = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Guess a number");
                scanner.nextLine();
                continue;
            }
            if (input < number) {
                System.out.println("Higher!");
                continue;
            }
            if (input == number) {
                break;
            }
            System.out.println("Lower!");
        }
        scanner.nextLine();
        System.out.println("Correct! You guessed the number!");
        Thread.sleep(1500);
        System.out.println("Do you want to play again? (yes, y, no, n)");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y")) {
            System.out.println("Welcome back! Hope you do better this time!");
            Thread.sleep(1500);
            System.out.println("Type in a number from 0 - 100");
            game();
            return;
        }
        System.out.println("Bye!");
    }
}