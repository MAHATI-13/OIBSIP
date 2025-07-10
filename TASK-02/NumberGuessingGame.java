import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        int maxRounds = 3;
        int totalScore = 0;
        System.out.println("🎯 Welcome to Number Guessing Game!");

        for (int round = 1; round <= maxRounds; round++) {
            int numberToGuess = rand.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 5;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + round + ": Guess a number between 1 and 100");

            while (attempts < maxAttempts) {
                System.out.print("Attempt " + (attempts + 1) + ": Enter your guess: ");
                int guess = sc.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("✅ Correct! You've guessed it in " + attempts + " attempts.");
                    totalScore += (6 - attempts) * 10;  
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("🔼 Too low!");
                } else {
                    System.out.println("🔽 Too high!");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
            }
        }

        System.out.println("\n🎉 Game Over! Your total score: " + totalScore);
        sc.close();
    }
}