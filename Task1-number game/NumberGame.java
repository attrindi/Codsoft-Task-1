import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    private static final int MAX_ATTEMPTS = 5;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;
        int totalRounds = 0;
        int totalWins = 0;

        while (playAgain) {
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            boolean hasGuessedCorrectly = false;

            System.out.println("A number between 1 and 100 has been generated.");
            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess (Attempt " + (attempts + 1) + " of " + MAX_ATTEMPTS + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (userGuess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Congratulations! You guessed the number!");
                    hasGuessedCorrectly = true;
                    break;
                }
            }

            if (!hasGuessedCorrectly) {
                System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
            } else {
                totalWins++;
            }
            totalRounds++;

            System.out.println("Current score: " + totalWins + " wins out of " + totalRounds + " rounds.");

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            if (!response.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("Thank you for playing! Final score: " + totalWins + " wins out of " + totalRounds + " rounds.");
        scanner.close();
    }
}
