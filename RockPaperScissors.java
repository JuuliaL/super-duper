import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Displaying options
        System.out.println("Enter your choice: \n1. Rock\n2. Paper\n3. Scissors");
        int userChoice = scanner.nextInt();

        // Generating random choice for computer
        int computerChoice = random.nextInt(3) + 1;

        // Displaying choices
        System.out.println("Your choice: " + convertChoiceToString(userChoice));
        System.out.println("Computer's choice: " + convertChoiceToString(computerChoice));

        // Determining the winner
        if (userChoice == computerChoice) {
            System.out.println("It's a tie!");
        } else if ((userChoice == 1 && computerChoice == 3) ||
                   (userChoice == 2 && computerChoice == 1) ||
                   (userChoice == 3 && computerChoice == 2)) {
            System.out.println("Congratulations! You win!");
        } else {
            System.out.println("Oops! Computer wins!");
        }
    }

    // Method to convert choice number to string
    public static String convertChoiceToString(int choice) {
        switch (choice) {
            case 1:
                return "Rock";
            case 2:
                return "Paper";
            case 3:
                return "Scissors";
            default:
                return "Invalid Choice";
        }
    }
}
