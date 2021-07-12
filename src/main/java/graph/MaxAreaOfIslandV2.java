package graph;


import java.util.LinkedList;
import java.util.Queue;

// Leetcode 695 Tags: Facebook
public class MaxAreaOfIslandV2 {

    public static void main(String[] args) {
        MaxAreaOfIslandV2 obj = new MaxAreaOfIslandV2();
        System.out.println(obj.maxAreaOfIsland(new int[][]{{0,0,1,0,0,0,0,1,0,0,0,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,1,1,0,1,0,0,0,0,0,0,0,0},
        {0,1,0,0,1,1,0,0,1,0,1,0,0},
        {0,1,0,0,1,1,0,0,1,1,1,0,0},
        {0,0,0,0,0,0,0,0,0,0,1,0,0},
        {0,0,0,0,0,0,0,1,1,1,0,0,0},
        {0,0,0,0,0,0,0,1,1,0,0,0,0}}));
    }

    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (grid[row][column] == 1) {
                    grid[row][column] = 0;
                    int area = 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{row, column});
                    while(!queue.isEmpty()){
                        int[] cell = queue.poll();
                        for (int[] direction : directions) {
                            int newRow = cell[0] + direction[0];
                            int newColumn = cell[1] + direction[1];
                            if (newRow >= 0 && newRow < m && newColumn >= 0
                                    && newColumn < n && grid[newRow][newColumn] == 1) {
                                grid[newRow][newColumn] = 0;
                                queue.add(new int[]{newRow, newColumn});
                                area++;
                            }
                        }
                    }
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
