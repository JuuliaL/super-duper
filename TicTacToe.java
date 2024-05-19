import java.util.Scanner;

public class Main {

    static final char X = 'X';
    static final char O = 'O';
    static final char E = ' ';

    public static void main(String[] args) {
        play();
    }

    public static void play() {
        char[][] grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                grid[i][j] = E;
            }
        }
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");
        String table = """

                    Table legend:
                    r1c1|r1c2|r1c3
                    ____|____|____
                    r2c1|r2c2|r2c3
                    ____|____|____
                    r3c1|r3c2|r3c3
                        |    |
                        """;

        boolean player1turn = true;

        for (; ; ) {

            char val = player1turn ? X : O; // if player1turn is true, val is X, else val is O
            String playerName = player1turn ? "Player 1 (X)" : "Player 2 (O)";

            System.out.println(table);
            System.out.println(playerName + ", enter the cell name for your move (e.g. r1c1): ");
            String input = scanner.nextLine();

            switch (input) {
                case "r1c1" -> {
                    if (grid[0][0] != E) {
                        System.out.println("Cell is already taken, please choose another cell.");
                        continue;
                    }
                    grid[0][0] = val;
                }
                case "r1c2" -> {
                    if (grid[0][1] != E) {
                        System.out.println("Cell is already taken, please choose another cell.");
                        continue;
                    }
                    grid[0][1] = val;
                }
                case "r1c3" -> {
                    if (grid[0][2] != E) {
                        System.out.println("Cell is already taken, please choose another cell.");
                        continue;
                    }
                    grid[0][2] = val;
                }
                case "r2c1" -> {
                    if (grid[1][0] != E) {
                        System.out.println("Cell is already taken, please choose another cell.");
                        continue;
                    }
                    grid[1][0] = val;
                }
                case "r2c2" -> {
                    if (grid[1][1] != E) {
                        System.out.println("Cell is already taken, please choose another cell.");
                        continue;
                    }
                    grid[1][1] = val;
                }
                case "r2c3" -> {
                    if (grid[1][2] != E) {
                        System.out.println("Cell is already taken, please choose another cell.");
                        continue;
                    }
                    grid[1][2] = val;
                }
                case "r3c1" -> {
                    if (grid[2][0] != E) {
                        System.out.println("Cell is already taken, please choose another cell.");
                        continue;
                    }
                    grid[2][0] = val;
                }
                case "r3c2" -> {
                    if (grid[2][1] != E) {
                        System.out.println("Cell is already taken, please choose another cell.");
                        continue;
                    }
                    grid[2][1] = val;
                }
                case "r3c3" -> {
                    if (grid[2][2] != E) {
                        System.out.println("Cell is already taken, please choose another cell.");
                        continue;
                    }
                    grid[2][2] = val;
                }
                default -> {
                    System.out.println("Invalid cell name, please try again.");
                    continue;
                }
            }


            //Print the updated table after the move to the console with println


            System.out.println("Updated table: ");
            System.out.println("___ ___ ___");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(label(grid[i][j]));
                    if (j != 2) {
                        System.out.print("|");
                    }
                }
                System.out.println();
                System.out.println("___|___|___");


            }


            //Check whether or not the row chosen by user contains all 1.

            for (int i = 0; i < 3; i++) {
                if (grid[i][0] == val && grid[i][1] == val && grid[i][2] == val) {
                    System.out.println("Player " + val + " wins!");
                    return;
                }
            }

            //Check whether or not the column chosen by user contains all 1.

            for (int i = 0; i < 3; i++) {
                if (grid[0][i] == val && grid[1][i] == val && grid[2][i] == val) {
                    System.out.println("Player " + val + " wins!");
                    return;
                }
            }

            //Check whether or not the diagonal chosen by user contains all 1.

            if (grid[0][0] == val && grid[1][1] == val && grid[2][2] == val) {
                System.out.println("Player " + val + " wins!");
                return;
            }
            if (grid[0][2] == val && grid[1][1] == val && grid[2][0] == val) {
                System.out.println("Player " + val + " wins!");
                return;
            }


            //Switch the turn after every move.

            player1turn = !player1turn;

            //Check whether the playing field is full and make it draw, if it is full.

            boolean isFull = true;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (grid[i][j] == E) {
                        isFull = false;
                        break;
                    }
                }
            }
            if (isFull) {
                System.out.println("It's a draw!");
                return;
            }

        }

    }

    private static String label(char i) {

        if (i == X) {
            return " X ";
        } else if (i == O) {
            return " O ";
        } else {
            return "   ";
        }
    }


}
