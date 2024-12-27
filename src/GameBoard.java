import java.util.Scanner;

public class GameBoard {
    char[][] board = new char[3][3];
    char defaultChar = ' ';
    // methods
    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.board[i][j] = defaultChar;
            }
        }
    }
    public boolean availableSquares(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == defaultChar) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean hasWon(char[][] board) {
        if (board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != defaultChar) {
            return true;
        } else if (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] != defaultChar) {
            return true;
        }
        for (int i = 0; i < 2; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][1] != defaultChar) {
                return true;
            } else if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != defaultChar) {
                return true;
            }
        }
        return false;
    }

    public void insertChar(int squareNumber, int turn, Scanner scanner, int playerNum) {
        squareNumber--;
        assert(squareNumber >= 1 && squareNumber <= 3);
        char c = 'X';
        int x = squareNumber / 3;
        int y = squareNumber % 3;

        if (turn % 2 == 0) c = 'O';
        if (this.board[x][y] != defaultChar) {
            System.out.println("Invalid Move");
            getPlayerInput(scanner, turn, playerNum);
        };
        this.board[x][y] = c;
    }

    public void printBoard() {
        for (char[] row : this.board) {
            System.out.println(row[0] + "|" + row[1] + "|" + row[2]);
        }
        System.out.println("\n");
    }
    public void showCoords() {
        System.out.println("Here are the coordinates for the grid! \n");
        System.out.println("1 | 2 | 3");
        System.out.println("4 | 5 | 6");
        System.out.println("7 | 8 | 9");
    }

    public void getPlayerInput(Scanner scanner, int turn, int playerNum) {
        int squareNumber = -1;
        System.out.println("Player " + playerNum + " turn " + turn);
        System.out.println("Enter number for the square you would like to play");
        String inputString = scanner.nextLine();
        // Validating Player Input
        if (inputString.length() != 1 || !Character.isDigit(inputString.charAt(0))) {
            System.out.println("Invalid move");
            System.out.println("Try again. Pick a square");
            // If Input Is Invalid, Recursively Call getPlayerInput Function
            getPlayerInput(scanner, turn, playerNum);
        } else {
            squareNumber = Integer.parseInt(inputString);
        }
        if (squareNumber >= 1) {
            this.insertChar(squareNumber, turn, scanner, playerNum);
        }
    }
}