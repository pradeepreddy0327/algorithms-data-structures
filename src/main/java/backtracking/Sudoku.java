package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sudoku {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] q = new char[][] {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        char[][] q2 = new char[][] {
                { '.', '.', '.', '.', '.', '7', '.', '.', '9' },
                { '.', '4', '.', '.', '8', '1', '2', '.', '.' },
                { '.', '.', '.', '9', '.', '.', '.', '1', '.' },
                { '.', '.', '5', '3', '.', '.', '.', '7', '2' },
                { '2', '9', '3', '.', '.', '.', '.', '5', '.' },
                { '.', '.', '.', '.', '.', '5', '3', '.', '.' },
                { '8', '.', '.', '.', '2', '3', '.', '.', '.' },
                { '7', '.', '.', '.', '5', '.', '.', '4', '.' },
                { '5', '3', '1', '.', '7', '.', '.', '.', '.' } };
        char[][] q3 = new char[][] {
                { '1', '5', '6', '2', '3', '7', '4', '8', '9' },
                { '9', '4', '7', '5', '8', '1', '2', '3', '6' },
                { '3', '2', '8', '9', '6', '4', '5', '1', '7' },
                { '6', '1', '5', '3', '4', '8', '9', '7', '2' },
                { '2', '9', '3', '7', '1', '6', '8', '5', '4' },
                { '4', '7', '2', '8', '9', '5', '3', '6', '1' },
                { '8', '6', '4', '1', '2', '3', '7', '9', '5' },
                { '7', '8', '9', '6', '5', '2', '1', '4', '3' },
                { '5', '3', '1', '4', '7', '9', '6', '2', '8' } };

        Sudoku s = new Sudoku();
        System.out.println(Arrays.deepToString(s.solveSudoku(q2)));
        System.out.println(s.isValid(q3));
    }

    Character[] chars = new Character[] { '1', '2', '3', '4', '5', '6', '7',
            '8', '9' };

    public char[][] solveSudoku(char[][] board) {
        List<int[]> cells = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    cells.add(new int[] { i, j });
                }
            }
        }
        backTrack(board, cells, 0);
        return board;
    }

    private boolean backTrack(char[][] board, List<int[]> cells, int x) {
        System.out.println(x);
        if (x >= cells.size()) {
            int[] cell = cells.get(x - 1);
            return isValid(board, cell[0], cell[1]);
        } else {
            int[] cell = cells.get(x);
            List<Character> cs = getPossibleValues(board, cell[0], cell[1]);
            for (Character c : cs) {
                board[cell[0]][cell[1]] = c;
                if (backTrack(board, cells, x + 1)) {
                    return true;
                }
                board[cell[0]][cell[1]] = '.';
            }
        }
        return false;
    }

    public boolean isValid(char[][] board) {
        System.out.println("isValid");
        for (int i = 0; i < 9; i++) {
            List<Character> r = new ArrayList<>(Arrays.asList(chars));
            List<Character> c = new ArrayList<>(Arrays.asList(chars));
            for (int j = 0; j < 9; j++) {
                r.remove(new Character(board[i][j]));
                c.remove(new Character(board[j][i]));
            }
            if (c.size() > 0 || r.size() > 0) {
                return false;
            }
        }

        for (int x = 0; x < 9; x += 3) {
            for (int y = 0; y < 9; y += 3) {
                List<Character> g = new ArrayList<>(Arrays.asList(chars));
                for (int i = x; i < x + 3; i++) {
                    for (int j = y; j < y + 3; j++) {
                        g.remove(new Character(board[i][j]));
                    }
                }
                if (g.size() > 0) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int x, int y) {
        List<Character> r = new ArrayList<>(Arrays.asList(chars));
        List<Character> c = new ArrayList<>(Arrays.asList(chars));
        for (int i = 0; i < 9; i++) {
            r.remove(new Character(board[x][i]));
            c.remove(new Character(board[i][y]));
        }
        if (c.size() > 0 || r.size() > 0) {
            return false;
        }
        List<Character> g = new ArrayList<>(Arrays.asList(chars));
        int gridX = (x / 3) * 3;
        int gridY = (y / 3) * 3;
        for (int i = gridX; i < gridX + 3; i++) {
            for (int j = gridY; j < gridY + 3; j++) {
                if (board[x][i] != '.') {
                    g.remove(new Character(board[i][j]));
                }
            }
        }
        return g.size() == 0;
    }

    private List<Character> getPossibleValues(char[][] board, int x, int y) {
        List<Character> p = new ArrayList<>(Arrays.asList(chars));
        for (int i = 0; i < 9; i++) {
            if (board[x][i] != '.') {
                p.remove(new Character(board[x][i]));
            }
            if (board[i][y] != '.') {
                p.remove(new Character(board[i][y]));
            }
        }
        int gridX = (x / 3) * 3;
        int gridY = (y / 3) * 3;
        for (int i = gridX; i < gridX + 3; i++) {
            for (int j = gridY; j < gridY + 3; j++) {
                if (board[x][i] != '.') {
                    p.remove(new Character(board[i][j]));
                }
            }
        }
        return p;
    }

}
