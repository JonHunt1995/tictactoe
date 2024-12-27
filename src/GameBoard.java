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
    public void insertChar(int squareNumber, int turn) {
        squareNumber--;
        assert(squareNumber >= 1 && squareNumber <= 3);
        char c = 'X';
        int x = squareNumber / 3;
        int y = squareNumber % 3;

        if (turn % 2 == 0) c = 'O';
        this.board[x][y] = c;
    }
    public void printBoard() {
        for (char[] row : this.board) {
            System.out.println(row);
        }
        System.out.println("\n");
    }
    public void showCoords() {
        System.out.println("Here are the coordinates for the grid! \n");
        System.out.println("1 | 2 | 3");
        System.out.println("4 | 5 | 6");
        System.out.println("7 | 8 | 9");
    }
}