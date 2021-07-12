package graph;


// Leetcode 695 Tags: Facebook
public class MaxAreaOfIsland {

    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int     m;
    int     n;

    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int maxArea = 0;
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (grid[row][column] == 1) {
                    grid[row][column] = 0;
                    maxArea = Math.max(maxArea, dfs(grid, row, column));
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int row, int column) {
        int area = 1;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newColumn = column + direction[1];
            if (newRow >= 0 && newRow < m && newColumn >= 0
                    && newColumn < n && grid[newRow][newColumn] == 1) {
                grid[newRow][newColumn] = 0;
                area += dfs(grid, newRow, newColumn);
            }
        }
        return area;
    }
}
