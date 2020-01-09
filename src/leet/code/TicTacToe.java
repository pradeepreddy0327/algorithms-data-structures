package leet.code;

public class TicTacToe {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    /** Initialize your data structure here. */
    int[][] board;
    int n;

    public TicTacToe(int n) {
        this.n = n;
        board = new int[n][n];

    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     * 
     * @param row
     *            The row of the board.
     * @param col
     *            The column of the board.
     * @param player
     *            The player, can be either 1 or 2.
     * @return The current winning condition, can be either: 0: No one wins. 1:
     *         Player 1 wins. 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        board[row][col] = player;
        boolean rowMatch = true;
        boolean colMatch = true;
        for (int i = 0; i < n; i++) {
            if (board[row][i] != player) {
                rowMatch = false;
            }
            if (board[i][col] != player) {
                colMatch = false;
            }
        }
        if (rowMatch || colMatch) {
            return player;
        }
        if (row == col) {
            boolean d1Match = true;
            for (int i = 0; i < n; i++) {
                if (board[i][i] != player) {
                    d1Match = false;
                    break;
                }
            }
            if (d1Match) {
                return player;
            }
        }
        if (row + col == n - 1) {
            boolean d2Match = true;
            for (int i = 0; i < n; i++) {
                if (board[i][n - i - 1] != player) {
                    d2Match = false;
                    break;
                }
            }
            if (d2Match) {
                return player;
            }
        }
        return 0;
    }

}
