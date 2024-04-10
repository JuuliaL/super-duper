import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of lines: ");
        int lines = scanner.nextInt();

        // Loop to print the specified number of lines
        for (int i = 1; i <= lines; i++) {
            // Loop to print the specific symbol for each line
            for (int j = 1; j <= i; j++) {
                System.out.print("_");
            }
            // Move to the next line after printing each line
            System.out.println();
        }

        scanner.close();
    }
}
