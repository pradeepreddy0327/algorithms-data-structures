package leet.code;


public class DungeonGame {

	// leetcode 174
	public static void main(String[] args) {
		int[][] d = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };
		int[][] e = { { 0, -5 }, { 0, 0 } };
		int[][] f = { { -61, -35, -50, -88, 8, -2, 27, -68, 23 }, { -82, -89, -13, 44, -27, 43, 5, -39, 24 },
				{ -65, -4, -75, -32, -58, -96, -5, -2, -98 }, { 3, -92, 27, -78, -92, -16, -93, -60, 10 },
				{ -28, 9, -60, 1, -70, -4, -94, -58, 8 }, { 41, -1, 12, -6, -4, -77, -21, 18, 8 },
				{ -13, -99, -15, -17, -57, 9, 18, 28, 18 }, { -72, 15, 35, 36, -34, -43, 6, -18, 41 },
				{ -72, -49, -18, 35, -48, -23, -71, 9, -1 }, { -49, 17, -97, -61, -25, -13, -59, -35, -72 } };
		
		System.out.println(new DungeonGame().calculateMinimumHP(d));
		System.out.println(new DungeonGame().calculateMinimumHP(e));
		System.out.println(new DungeonGame().calculateMinimumHP(f));

	}

	public int calculateMinimumHP(int[][] d) {
		int m = d.length;
		int n = d[0].length;
		int[][] h = new int[m][n];
		h[m - 1][n - 1] = 1 - d[m - 1][n - 1];
		h[m - 1][n - 1] = h[m - 1][n - 1] <= 0 ? 1 : h[m - 1][n - 1];
		for (int i = m - 1; i >= 0; i--) {
			for (int j = n - 1; j >= 0; j--) {
				if (i == m - 1 && j == n - 1)
					continue;
				int hd = i + 1 == m ? Integer.MAX_VALUE : h[i + 1][j];
				int hr = j + 1 == n ? Integer.MAX_VALUE : h[i][j + 1];
				h[i][j] = Math.min(hd, hr) - d[i][j];
				h[i][j] = h[i][j] <= 0 ? 1 : h[i][j];

			}
		}
		return h[0][0];
	}

}
