/*public class Main {
1. Easy -> Initialize a string array and try to input and output data
 We want to define an array city names.
 We want to populate it (could be through the scanner, or just writing
arr[0] = "Riga";

arr[0] = scanner.nextLine();

2. Challenging -> Find the largest number in the array and find the smallest number in the array
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] cityNames = new String[5];
        /*
        Declare and initialize an array
       //String[] cityNames = {"Riga", "Tallinn", "London", "Paris", "Dublin"};

        // Print each element of the array
        for (int i = 0; i < cityNames.length; i++) {
            System.out.println("Element at index " + i + ": " + cityNames[i]);
            */
        // Input city names from the user
        for (int i = 0; i < cityNames.length; i++) {
            System.out.println("Enter city name for index " + i + ": ");
            cityNames[i] = scanner.nextLine();
        }

        // Print each element of the array
        for (int i = 0; i < cityNames.length; i++) {
            System.out.println("Element at index " + i + ": " + cityNames[i]);
        }
        /*
        2. Challenging -> Find the largest number in the array and find the smallest number in the array
        */

        System.out.println("Length of the array: " + cityNames.length);
System.out.println("The last city in the array is: " + cityNames[cityNames.length - 1]);
System.out.println("The first city in the array is: " + cityNames[0]);
