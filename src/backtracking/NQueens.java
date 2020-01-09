package backtracking;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

public class NQueens {

	public static void main(String[] args) {
		List<List<Integer>> ans = new NQueens().nQueens(6);
		PrintUtil.printList(ans);
	}

	public List<List<Integer>> nQueens(int n) {
		List<List<Integer>> ans = new ArrayList<>();
		backTrack(ans, new ArrayList<Integer>(), n, new boolean[n][n], 0);
		return ans;
	}

	private void backTrack(List<List<Integer>> ans, List<Integer> l, int n, boolean[][] board, int c) {
		if (l.size() == n) {
			ans.add(l);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!board[i][c]) {
				boolean[][] copy = copy(board);
				queenVisitBoard(board, i, c);
				l.add(i + 1);
				backTrack(ans, new ArrayList<Integer>(l), n, board, c + 1);
				l.remove(l.size() - 1);
				board = copy;
			}
		}
	}

	private void queenVisitBoard(boolean[][] b, int r, int c) {
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b.length; j++) {
				if (i == r || j == c || Math.abs(r - i) == Math.abs(c - j)) {
					b[i][j] = true;
				}
			}
		}
	}

	private boolean[][] copy(boolean[][] b) {
		boolean[][] copy = new boolean[b.length][b.length];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				copy[i][j] = b[i][j];
			}
		}
		return copy;
	}

}
