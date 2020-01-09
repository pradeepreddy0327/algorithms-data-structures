package leet.code;

/**
 * Leet Code Problem Number : 200
 */
public class NumberOfIslands {

	public static void main(String[] args) {
		char[][] grid = { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
		System.out.println(numIslands(grid));
	}

	private static int numIslands(char[][] grid) {
		int c = 0;
		boolean[][] b = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1' && !b[i][j]) {
					c++;
					traverse(grid, b, i, j);
				}
			}
		}
		return c;
	}

	private static void traverse(char[][] grid, boolean[][] b, int i, int j) {
		if (i >= 0 && j >= 0 && i < b.length && j < b[i].length && !b[i][j] && grid[i][j] == '1') {
			b[i][j] = true;
			traverse(grid, b, i - 1, j);
			traverse(grid, b, i, j - 1);
			traverse(grid, b, i + 1, j);
			traverse(grid, b, i, j + 1);
		}
	}

}
