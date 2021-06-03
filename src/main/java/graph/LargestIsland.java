package graph;

import java.util.HashSet;
import java.util.Set;

// leetcode 827  tags: Facebook
public class LargestIsland {
    public static void main(String[] args) {
        LargestIsland obj = new LargestIsland();
        System.out.println(obj.largestIsland(new int[][]{{1, 0}, {1, 0}}));
    }

    public int largestIsland(int[][] grid) {
        int[] area = dfs(grid);
        int max = 0;
        int n = grid.length;
        for (int a : area) {
            max = Math.max(max, a);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int size = 0;
                    Set<Integer> addedGroupIds = new HashSet<>();
                    for (int[] adj : adjArr) {
                        int x = i + adj[0];
                        int y = j + adj[1];
                        if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] > 0 && !addedGroupIds.contains(grid[x][y])) {
                            size += area[grid[x][y]];
                            addedGroupIds.add(grid[x][y]);
                        }
                    }
                    max = Math.max(max, size + 1);
                }
            }
        }
        return max;
    }

    int[][] adjArr = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private int[] dfs(int[][] grid) {
        int n = grid.length;
        int areaIndex = 2;
        int[] area = new int[n * n + 2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = areaIndex;
                    area[areaIndex] = recurse(grid, i, j, areaIndex);
                    areaIndex++;

                }
            }
        }
        return area;
    }

    private int recurse(int[][] grid, int i, int j, int componentIndex) {
        int n = grid.length;
        int visited = 1;
        for (int[] adj : adjArr) {
            int x = i + adj[0];
            int y = j + adj[1];
            if (x >= 0 && y >= 0 && x < n && y < n && grid[x][y] == 1) {
                grid[x][y] = componentIndex;
                visited += recurse(grid, x, y, componentIndex);
            }
        }
        return visited;
    }
}


