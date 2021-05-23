package util;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) throws Exception {
        TicTacToe ticTacToe = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        String myString = scanner.nextLine();
        while (myString != null) {
            String[] input = myString.split(" ");
            ticTacToe.addToken('X', Integer.valueOf(input[0]),
                    Integer.valueOf(input[1]));
            myString = scanner.nextLine();
        }

        // ticTacToe.printBoard();
        // ticTacToe.makeAIMove();
        // ticTacToe.makeAIMove();
        // ticTacToe.makeAIMove();
        // ticTacToe.makeAIMove();
        // ticTacToe.makeAIMove();
        // ticTacToe.makeAIMove();
        // ticTacToe.makeAIMove();
        // ticTacToe.makeAIMove();
        System.out.println(ticTacToe.isBoardFull());
    }

    private Character[][] board;
    private int filledCells;

    public TicTacToe() {
        board = new Character[3][3];
    }

    public void addToken(char c, int x, int y) throws Exception {
        if (board[x][y] != null) {
            return;
        }
        board[x][y] = c;
        filledCells++;
        makeAIMove();
    }

    public void printBoard() {
        for (Character[] row : board) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] != null ? row[i] : '-');
                if (i < row.length - 1) {
                    System.out.print('|');
                }
            }
            System.out.println();
        }
    }

    public boolean isBoardFull() {
        return filledCells == board.length * board.length;
    }

    public void makeAIMove() throws Exception {
        if (isBoardFull()) {
            throw new Exception("Board if full.");
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == null) {
                    board[i][j] = 'O';
                    filledCells++;
                    printBoard();
                    return;
                }
            }
        }

    }
}
