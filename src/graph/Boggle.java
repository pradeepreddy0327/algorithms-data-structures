package graph;

public class Boggle {

	// Leetcode Problem 79

	public static void main(String[] args) {
		char[][] board = { { 'a', 'b' } };
		String word = "ba";

		System.out.println(new Boggle().exist(board, word));

	}

	public boolean exist(char[][] board, String word) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (dfs(board, word, i, j, 0))
					return true;
			}
		}

		return false;
	}

	boolean dfs(char[][] b, String w, int i, int j, int k) {
		if (k == w.length())
			return true;
		if (i < 0 || i >= b.length || j < 0 || j >= b[i].length || b[i][j] == '#')
			return false;
		if (b[i][j] == w.charAt(k)) {
			char temp = b[i][j];
			b[i][j] = '#';
			if (dfs(b, w, i - 1, j, k + 1))
				return true;
			if (dfs(b, w, i + 1, j, k + 1))
				return true;
			if (dfs(b, w, i, j - 1, k + 1))
				return true;
			if (dfs(b, w, i, j + 1, k + 1))
				return true;
			b[i][j] = temp;
		}
		return false;
	}

}
