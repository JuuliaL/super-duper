import java.util.Scanner;

public class Main {
    // Method to print a prompt
    public static void printPrompt(String prompt) {
        System.out.println(prompt);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printPrompt("Welcome, brave adventurer! What is your name?");
        String adventurerName = scanner.nextLine();

        printPrompt("Greetings, " + adventurerName + "! Are you ready to continue your quest? (yes/no)");
        String readyResponse = scanner.nextLine();

        if (readyResponse.equalsIgnoreCase("no")) {

              System.out.println("Farewell, " + adventurerName + "! Come back when you are ready!");

            // Game over...
        }
      
      if (readyResponse.equalsIgnoreCase("yes")) {
          System.out.println("Splendid! Let's proceed.");
          System.out.println("You find yourself at a fork in the code. Which path will you take?");
          System.out.println("1. The Enchanted Loop Forest");
          System.out.println("2. The Mysterious Conditional Castle");
          int chosenPath = scanner.nextInt();
                  

          if (chosenPath == 1) {
            System.out.println("Invalid choice! The path crumbles beneath your feet.");          
        } 

      if (chosenPath == 2) {
          System.out.println("Welcome to the Mysterious Conditional Castle!");
          handleRiddle("Java"); 
        // Call the riddle method 
          
      }    
      }
      }
   // Method to handle riddles
      public static void handleRiddle(String correctAnswer) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Answer this riddle to proceed. \nWhat has keys but can't open locks?");
          String userAnswer = scanner.next();

          if (userAnswer.equalsIgnoreCase(correctAnswer)) {
              System.out.println("Correct! The gates swing open. May your code always compile!");
              
          } else {
              System.out.println("Incorrect! The castle walls close in. Try again!");
              // End of the game
          }
        }     
      } 

