package ood;

public class TicTacToe {
    private static final int DEFAULT_BOARD_SIZE = 3;
    private Cell[][] board;
    int filled = 0;

    public TicTacToe() {
        board = new Cell[DEFAULT_BOARD_SIZE][DEFAULT_BOARD_SIZE];
    }

    public TicTacToe(int size) {
        board = new Cell[size][size];
    }

    public boolean setValue(int x, int y, Cell value) {
        board[x][y] = value;
        filled++;
        printBoard();
        return isWinner(x, y, value);
    }

    private boolean isWinner(int x, int y, Cell value) {
        int rowMatched = 0, columnMatched = 0, diag1Matched = 0,
                diag2Matched = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[x][i] == value)
                rowMatched++;
            if (board[i][y] == value)
                columnMatched++;
        }
        int j = board.length - 1;
        for (int i = 0; i < board.length; i++) {
            if (board[i][i] == value)
                diag1Matched++;
            if (board[j--][i] == value)
                diag2Matched++;
        }
        return rowMatched == board.length || columnMatched == board.length
                || diag1Matched == board.length || diag2Matched == board.length;
    }

    public boolean isFilled() {
        return filled == board.length * board.length;
    }

    public int[] getAvailablePosition() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == null)
                    return new int[] { i, j };
            }
        }
        return null;
    }

    private void printBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
        }
        System.out.println();
    }
}

enum Cell {
    X, O

}
