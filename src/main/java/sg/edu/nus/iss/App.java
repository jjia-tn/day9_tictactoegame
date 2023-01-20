package sg.edu.nus.iss;

import java.util.Scanner;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        // System.out.println("Hello World!");

        String[] tttBoard = new String[9];
        // player X and O
        String player = "X";
        String winner = "";

        // populating the tic-tac-toe board with 1 to 9
        for (int i = 0; i < 9; i++) {
            tttBoard[i] = String.valueOf(i + 1);
        }

        TicTacToe ttt = new TicTacToe();

        // print out the initial tic-tac-toe board
        ttt.printBoard(tttBoard);

        Scanner scanner = new Scanner(System.in);

        while (winner == "") {

            System.out.println("Tic-Tac-Toe game");
            System.out.println("-----------------");
            System.out.println(player + " will play now...");
            
            // play tic-tac-toe logic here...
            Integer input;

            System.out.println("(Player " + player + ") Enter your position: ");
            input = scanner.nextInt();

            // only accept keyboard input 1 to 9
            if ((input > 0) && (input < 10)) {

            } else {
                System.out.println("Invalid input: Only number 1 to 9 is allowed.");
                continue;
            }

            // assign 'X' or 'O' to position if it is number
            if ((tttBoard[input - 1]).equals(String.valueOf(input))) {
                tttBoard[input - 1] = player;

                // switch to another player's turn
                if (player.equalsIgnoreCase("X")) {
                    player = "O";
                } else {
                    player = "X";
                }
            } else {
                System.out.println("Position already taken up. Please enter another position number");
            }

            ttt.printBoard(tttBoard);
            winner = ttt.checkWinner(tttBoard);
        }
            
        if (winner.equalsIgnoreCase("draw")) {
            System.out.println("It's a " + winner);
        } else {
            System.out.println("The winner of this game is " + winner);
        }

        scanner.close();
    }
}
