import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        while (true) {
            System.out.println("Welcome to Number Guessing Game");
            System.out.println("Please select difficulty: \n 1 - easy(1 - 50) \n 2 - medium(1-100) \n 3 - hard(1-200)");
            int diff = scan.nextInt();

            int max = 0;

            try {
                switch (diff) {
                    case 1:
                        System.out.println("Guess a number between 1 - 50");
                        max = 50;
                        break;
                    case 2:
                        System.out.println("Guess a number between 1 - 100");
                        max = 100;
                        break;
                    case 3:
                        System.out.println("Guess a number between 1 - 200");
                        max = 200;
                        break;
                    default:
                        throw new IllegalArgumentException("Please select a difficulty 1,2 or 3");
                }

                int target = rand.nextInt(max) + 1;
                int lives = 0;
                int guess = 0;

                while (lives < 5 && guess != target) {
                    System.out.println("Enter your guess: ");
                    try {
                        guess = scan.nextInt();
                        if (guess <= 0 || guess > max) {
                            throw new IllegalArgumentException("The number should be greater than 0 and not greater than the max number");
                        }

                        lives++;
                        if (guess == target) break;

                        if (guess < target) {
                            System.out.println("Guess Higher");
                        } else {
                            System.out.println("Guess Lower");
                        }

                        int difference = Math.abs(target - guess);
                        if (difference <= 10) {
                            System.out.println("You are very very close");
                        } else if (difference <= 25) {
                            System.out.println("You are close");
                        } else if (difference <= 50) {
                            System.out.println("You are getting there");
                        }

                        System.out.println("You have " + (5 - lives) + " Lives left");

                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage()); // Display the error message and ask for a new guess
                        scan.nextLine(); // Clear the buffer
                    }
                }

                if (guess != target) {
                    System.out.println("The number was " + target + ":(");
                } else {
                    System.out.println("Congratulations!! You Won!! The number was " + target);
                    int score = (5 - lives) * 10;
                    System.out.println("Your score: " + score);
                }

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Do you want to play again? (yes/no)");
            scan.nextLine(); // consume newline
            String choice = scan.nextLine();
            if (!choice.equalsIgnoreCase("yes")) {
                System.out.println("Thanks for playing");
                break;
            }
        }

        scan.close();
    }
}
