import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        guessingNumberGame();
    }

    public static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random()); // Generate a random number between 1 and 100
        int maxTrials = 5; // Set the maximum number of trials

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("A number has been chosen between 1 and 100.");
        System.out.println("You have " + maxTrials + " trials to guess the number.");

        for (int i = 0; i < maxTrials; i++) {
            System.out.print("Guess the number: ");
            int guess = sc.nextInt();

            if (guess == number) {
                System.out.println("Congratulations! You guessed the number.");
                break;
            } else if (guess < number) {
                System.out.println("The number is greater than " + guess);
            } else {
                System.out.println("The number is less than " + guess);
            }
        }

        if (number != sc.nextInt()) {
            System.out.println("You have exhausted all " + maxTrials + " trials.");
            System.out.println("The correct number was " + number);
        }
    }
}
