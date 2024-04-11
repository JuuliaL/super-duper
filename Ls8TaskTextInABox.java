/*
User provides a text, and then the program puts it in a square

for example, if user provides "WoTech"

==============
|             |
|    WoTech   |
|             |
==============
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create a new Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter text
        System.out.println("Enter the text to be printed:");
        String text = scanner.nextLine();

        // Calculate the side length of the square
        int sideLength = text.length() + 4; // Add 4 for the padding

        // Print the top border
        printBorder(sideLength);

        // Use a for loop to print the text with padding only in the middle
        for (int i = 0; i < 5; i++) {
            if (i == 2) { // This is the middle iteration
                System.out.println("|" + padText(text, sideLength - 2) + "|");
            } else {
                System.out.println("|" + padText("", sideLength - 2) + "|"); // Print empty line
            }
        }

        // Print the bottom border
        printBorder(sideLength);
    }

    // Helper method to print a border
    private static void printBorder(int length) {
        System.out.println("=".repeat(length));
    }

    // Helper method to pad the text with spaces
    private static String padText(String text, int targetLength) {
        int padding = targetLength - text.length();
        int leftPadding = padding / 2;
        int rightPadding = padding - leftPadding;
        return " ".repeat(leftPadding) + text + " ".repeat(rightPadding);


    }
}
