/*Develop a program, that iterates through numbers from 0 till X amount of times (X is user provided)
For numbers that are divided by 3: print out "Wo" .

For numbers that are divided by 5: print out "Tech". 

For numbers divided by 3 and 5: print out "WoTech".

MODULUS OPERATOR %
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of X: ");
        int X = scanner.nextInt();

        for (int i = 0; i <= X; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("WoTech");
            } else if (i % 3 == 0) {
                System.out.println("Wo");
            } else if (i % 5 == 0) {
                System.out.println("Tech");
            } else {
                System.out.println(i);
            }
        }
    }
}
