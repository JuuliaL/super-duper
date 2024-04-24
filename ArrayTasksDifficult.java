/* Difficult: 
Given an array of integers, write a Java program to find the maximum sum of two integers in the array. Solvable with 2 arrays

For example in an array like this:
[2, 3, 1, 5, 4]
The maximum sum would be 5 + 4 */
public class Task5 {
    public void solve(int[] numbers) {
 
        //Define an array to store integers.
        int[] num = new int[10];
        // Define a variable maxSum and initialize it as the sum of the first two numbers in the array.
        int maxSum = num[0] + num[1];
        // Start a loop to iterate over each element in the array:
        for (int i = 1; i < numbers.length; i++) {
            // a.  Inside this loop, get the value of numbers[i].
            int num1 = numbers[i];
            // Start another loop nested within the first loop:
            // a.  Inside this nested loop, iterate over each element in the array again using a different index j.
            for (int j = i + 1; j < numbers.length; j++) {
                // b.  Calculate the sum of numbers[i] and numbers[j].
                int num2 = numbers[j];
                int sum = num1 + num2;
                // c.  Compare this sum to maxSum. If it's greater than maxSum, update maxSum to this new sum.
                maxSum = sum > maxSum ? sum : maxSum;
            }
        }

        // After both loops have finished iterating, print out the value of maxSum, which represents the maximum sum of two digits in the array.
// [2, 3, 1, 5, 4]
        System.out.println("The maximum sum would be " + maxSum);
    }
}

/*
Very difficult
Fill the array with human names. (2 arrays)
Check how many different names are in the array
["Oskars", "Anna", "Andris"]
Result: 3

["Andris", "Oskars", "Elizabeth", "Oskars",  "Elizabeth"]
Result: 3

["Oskars"] - An empty array
Result: 1 */
public class Main {
    public void solve() {
        String names[] = {"Oskars", "Anna", "Andris", "Andris", "Oskars", "Elizabeth", "Oskars", "Elizabeth"};
        String namesUnique[] = new String[names.length];
        int uniqueCount = 0;

        for (int i = 0; i < names.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < uniqueCount; j++) {
                if (names[i].equals(namesUnique[j])) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                namesUnique[uniqueCount] = names[i];
                uniqueCount++;
            }
        }
        System.out.println("Result: " + uniqueCount);
    }
}


