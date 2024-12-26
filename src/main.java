import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        int playerNum = 1;

        board.initializeBoard();
        board.printBoard();
        while (board.hasWon(board.board) == false && board.availableSquares(board.board) == false) {
            int x = 0;
            int y = 0;
            if (turn % 2 == 0) {
                playerNum = 2;
            } else {
                playerNum = 1;
            }
            board.showCoords();

            System.out.println("Player " + playerNum + " turn " + turn);
            System.out.println("Enter x coordinate");
            x = scanner.nextInt();
            if (!(x >= 1 && x <= 3)) {
                System.out.println("Seriously, don't break my program! Try again.");
                System.out.println("Enter x coordinate");
                x = scanner.nextInt();
            }
            System.out.println("Enter y coordinate");
            y = scanner.nextInt();
            if (!(y >= 1 && y <= 3)) {
                System.out.println("Seriously, don't break my program! Try again.");
                System.out.println("Enter y coordinate");
                y = scanner.nextInt();
            }
            board.insertChar(x, y, turn);
            board.printBoard();
            turn++;
        }
        if (board.availableSquares(board.board) == true && board.hasWon(board.board) == false) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Player " + playerNum + " wins!");
        }
    }
}