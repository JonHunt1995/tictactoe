import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        int playerNum = 1;
        boolean valid = true;


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

            board.getPlayerInput(scanner, turn, playerNum);
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