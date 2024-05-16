/*
0 5 5 5 5 5 5 5 0 
1 0 5 5 5 5 5 0 7 
1 1 0 5 5 5 0 7 7 
1 1 1 0 5 0 7 7 7 
1 1 1 1 0 7 7 7 7 
1 1 1 0 6 0 7 7 7 
1 1 0 6 6 6 0 7 7 
1 0 6 6 6 6 6 0 7 
0 6 6 6 6 6 6 6 0 
*/


public class Main {
    public static void main(String[] args) {
        int[][] block = new int[9][9];

        // Fill the center diagonal with 5s
        for (int i = 0; i < 9; i++) {
            block[i][i] = 5;
        }

        // Fill the upper diagonals with numbers from 1 to 4
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {
                block[i][j] = (i + j) % 4 + 1;
            }
        }

        // Fill the lower diagonals with numbers from 6 to 9
        for (int i = 0; i < 9; i++) {
            for (int j = i + 1; j < 9; j++) {
                block[i][j] = (i + j) % 4 + 6;
            }
        }

        // Set the two diagonal lines to 0
        for (int i = 0; i < 9; i++) {
            block[i][i] = 0;
            block[i][8 - i] = 0;
        }

        // Set the numbers in the top part of the cube between 0s to 5
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 8 - i; j++) {
                block[i][j] = 5;
            }
        }
            // Set the numbers in the bottom part of the cube between 0s to 6
            for (int i = 5; i < 9; i++) {
                for (int j = 9 - i; j < i; j++) {
                    block[i][j] = 6;
                }

        }
        // Set the numbers in the left part of the cube between 0s to 1
        for (int j = 0; j< 4; j++) {
            for (int i = j + 1; i < 8 - j; i++) {
                block[i][j] = 1;
            }
        }

        // Set the numbers in the right part of the cube between 0s to 7
        for (int j = 5; j < 9; j++) {
            for (int i = 9 - j; i < j; i++) {
                block[i][j] = 7;
            }

        }

        // Print the block
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(block[i][j] + " ");
            }
            System.out.println();
        }
    }
}
