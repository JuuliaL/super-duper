/*
1. Create a program, where user can provide a title and a small text below the story.
Title should be wrapped with ====== at top and bottom, based on the title length.
Example: 
System asks for title and user provides "WoTech and Java is easy"
System asks for description and user provides "I have been learning Java for 6 weeks now."

Result: 
=======================
WoTech and Java is easy
=======================

I have been learning Java for 6 weeks now.
*/
import java.util.Scanner;
public class Main {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    System.out.println("Please provide a title: ");
    String title = scanner.nextLine();
    System.out.println("Please provide a description: ");
    String description = scanner.nextLine();
    int lineLength = title.length();
    
    printBorder(lineLength);
    System.out.println(title);
    printBorder(lineLength);
    System.out.println("\nDescription: " + description);

    scanner.close();
  }

  private static void printBorder(int length) {
      System.out.println("=".repeat(length));
  } 

}
