import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        int playerNum = 1;

        board.initializeBoard();
        board.printBoard();
        // Game Loop Continues Until Victory or Tie
        while (!board.hasWon() && !board.noAvailableSquares()) {
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
        if (board.noAvailableSquares() && !board.hasWon()) {
            System.out.println("It's a tie!");
        } else {
            System.out.println("Player " + playerNum + " wins!");
        }
    }
}