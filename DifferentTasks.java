/*
Easy:
1. Create a function that returns smallest number of 2 numbers.

For example:
User provides 5
User provides 7

Function returns 5
Main function prints out:
5 is the smallest number

*/
/*
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter a number: ");
      int num1 = input.nextInt();
      System.out.println("Enter another number: ");
      int num2 = input.nextInt();

      input.close();

      int smallestNumber = findSmallestNumber(num1, num2);
      System.out.println(smallestNumber + " is the smallest number");
    } catch (Exception e) {
      System.out.println("Invalid input, please insert whole number!");
    }

  }

  public static int findSmallestNumber(int num1, int num2) {
    return Math.min(num1, num2);
  }

}
*/

/*
2. Create a function that returns a multiplication of 3 different numbers
For example: 
User provides 5
User provides 7
User provides 3

Function returns 105
Main function prints out 105
*/
/*
import java.util.Scanner;
 public class Main {
 public static void main(String[] args) {
try {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter first number: ");
      int num1 = input.nextInt();
      System.out.println("Enter second number: ");
      int num2 = input.nextInt();
      System.out.println("Enter third number: ");
      int num3 = input.nextInt();

      input.close();

      int multipliedNumbers = multiplyNumbers(num1, num2, num3);
      System.out.println(multipliedNumbers + " is the value of the multiplied numbers");
    } catch (Exception e) {
      System.out.println("Invalid input, please insert whole number!");
    }

  }

  public static int multiplyNumbers(int num1, int num2, int num3) {
    return Math.multiplyExact(num1, num2) * num3;
  }

}
*/

/*
*3. Create a function that returns a combination of first name and last name
User provides "Oskars"
User provides "Klaumanis"

Function receives both of the names and returns "Oskars Klaumanis"
Main function prints out the result
*/
/*
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try {
      Scanner input = new Scanner(System.in);
      System.out.println("Enter first name: ");
      String firstName = input.nextLine();
      System.out.println("Enter last name: ");
      String lastName = input.nextLine();

      input.close();

      String fullName = combineNames(firstName, lastName);
      System.out.println(fullName + " is the full name");

    } catch (Exception e) {
      System.out.println("Invalid input, please try again!");

    }
  }

  public static String combineNames(String firstName, String lastName) {
    return firstName + " " + lastName;
  }

}
*/
/*
medium:
1. Parent simulator, a user provides a number (average grade) to the program, and if it's above 8, then parents go hooray, else they go sad

User creates 3 functions
    1. Function called hooraay(), is a void, and returns nothing. It's only job is to print out "Hooraay" in the console
    2. Function called sad(), is a void, and returns nothing. It's only job is to print out "Sad" in the console
    2. Function is called CheckGrades and receives int as value, but returns nothing. It's job is to call hooray() function, if the grade that it received is above 8, and call sad() function, if the grades received is less than 8
    *//*
        import java.util.Scanner;
        
        public class Main {
        public static void main(String[] args) {
          Scanner input = new Scanner(System.in);
          System.out.println("Enter grade from 1 to 10: ");
          int userGrade = input.nextInt();
          input.close();
          checkGrades(userGrade);
        }
        
        public static void hooraay() {
          System.out.println("Hooray!");
        }
        
        public static void sad() {
          System.out.println("Sad");
        }
        
        public static void checkGrades(int userGrade) {
          if (userGrade > 8) {
              hooraay();
          } else {
              sad();
          }
        }
        }*/

/*
Hard:
1. Fill the party list with people you would like to invite to the party.
Check whether or not "Anna" is in the array.
Check whether or not "Maris" is in the array.
["Oskars", "Anna", "Andris"]
Result: 
"Anna is in the party list"
"Maris is not in the party list"
*/
/*
import java.util.Scanner;

public class Main {
    // Define partyList as a class-level variable
    private static String[] partyList = { "Oskars", "Anna", "Andris" };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please provide a name to check: ");
        String providedName = input.nextLine();
        input.close();

        checkName(providedName);
    }

    public static void checkName(String providedName) {
        boolean isInvited = false;
        for (int i = 0; i < partyList.length; i++) {
            if (partyList[i].equals(providedName)) {
                isInvited = true;
                System.out.println(providedName + " is invited!");
                break;
            }
        }
        if (!isInvited) {
            System.out.println(providedName + " is not invited!");
        }
    }
}
*/
/*
2. Guess the Number Game
Generate a random number from 0 to 100
Make the user guess the number. If it's too high, or too low, let the user know
OPTIONAL: Give maximum of 6 guessues. */

/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        guessingNumberGame();
    }

    public static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        int number = 1 + (int) (100 * Math.random()); // Generate a random number between 1 and 100
        int maxTrials = 6; // Set the maximum number of trials

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

        sc.close(); // Close the scanner to release resources
    }
}*/
/*Very hard:
1. Grades in university
You have 3 students, each one of them has grades. (three different int arrays) 
Calculate the average grade for each student (sum of all grades and divide by grade count)

Example:
robertsGrades {8, 6, 7, 9, 10}
annasGrades {7, 10, 10, 9, 6}
franceskasGrades {8, 8, 8, 7, 6}

Result:
Robert's average grade is 8
Anna's average grade is 8.4
Franceska's average grade is 7.4
*/


public class Main {
    public static void main(String[] args) {
        // Define the grades for each student
        int[] robertsGrades = {8, 6, 7, 9, 10};
        int[] annasGrades = {7, 10, 10, 9, 6};
        int[] franceskasGrades = {8, 8, 8, 7, 6};

        // Calculate average grades
        double robertsAverage = calculateAverage(robertsGrades);
        double annasAverage = calculateAverage(annasGrades);
        double franceskasAverage = calculateAverage(franceskasGrades);

        // Display results
        System.out.println("Robert's average grade is " + robertsAverage);
        System.out.println("Anna's average grade is " + annasAverage);
        System.out.println("Franceska's average grade is " + franceskasAverage);
    }

    // Function to calculate average grade
    public static double calculateAverage(int[] grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.length;
    }
}
