import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Scanner scanner = new Scanner(System.in);
        int turn = 1;
        int playerNum = 1;
        boolean valid = true;
        void getPlayerInput(string inputString, int turn, int playerNum) {
            System.out.println("Player " + playerNum + " turn " + turn);
            System.out.println("Enter number for the square you would like to play");
            inputString = scanner.next();
            if (inputString.length() != 1 || !Character.isDigit(inputString.charAt(0)) || this.board[x][y] == defaultChar) {
                System.out.println("Invalid move");
                getPlayerInput(string inputString, int turn, int playerNum);
            }
            int squareNumber = inputString.parseInt();

            board.insertChar(squareNumber, turn);
        }

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
            System.out.println("Enter number for the square you would like to play");
            inputString = scanner.next();

            getPlayerInput(inputString, turn, playerNum);
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