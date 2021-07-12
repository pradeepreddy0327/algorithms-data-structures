package graph;

import java.util.LinkedList;
import java.util.Queue;


// leetcode 317  tags: Facebook
public class ShortestDistance {


    public static void main(String[] args) {
        ShortestDistance obj = new ShortestDistance();
        System.out.println(obj.shortestDistance(new int[][]{{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}}));
        System.out.println(obj.shortestDistance(new int[][]{{1, 0}}));
        System.out.println(obj.shortestDistance(new int[][]{{0, 2, 0, 0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 2, 2, 1, 0, 0, 2, 0, 2, 0, 2, 0, 0, 2, 2, 2, 0, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2},
                                                            {0, 0, 0, 0, 0, 2, 2, 0, 2, 0, 0, 0, 0, 0, 2, 0, 0, 2, 2, 0, 2, 2, 2, 2, 0, 0, 2, 2, 0, 0, 2, 2, 1, 0, 0, 2, 2, 0, 2, 0, 0},
                                                            {0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 2, 2, 0, 2, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 0, 0, 2, 2, 0},
                                                            {2, 2, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 2, 2, 2, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 1, 2, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2},
                                                            {0, 0, 2, 2, 0, 0, 2, 1, 2, 0, 0, 0, 0, 2, 1, 0, 2, 2, 0, 2, 0, 0, 0, 2, 1, 0, 2, 2, 0, 0, 0, 2, 0, 0, 0, 2, 2, 0, 2, 0, 0},
                                                            {0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 2, 2, 1, 2, 0, 2, 0, 0, 0, 2, 0, 2, 2, 0},
                                                            {2, 0, 0, 0, 2, 2, 0, 0, 0, 2, 1, 0, 2, 0, 0, 0, 0, 2, 0, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2},
                                                            {1, 0, 2, 2, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 2, 1, 2, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0},
                                                            {0, 2, 0, 0, 0, 1, 0, 0, 2, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 2, 2, 2, 0, 0, 2, 2, 0, 2, 2, 2, 2, 0, 0, 0, 0, 2, 0, 2, 0, 0, 2},
                                                            {0, 0, 2, 2, 0, 2, 2, 0, 2, 0, 1, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 2, 0, 0, 1},
                                                            {1, 2, 0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0},
                                                            {0, 1, 2, 2, 2, 2, 0, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 0, 2, 2, 0, 0, 0},
                                                            {2, 0, 2, 0, 2, 0, 0, 2, 0, 0, 0, 2, 0, 0, 2, 2, 0, 0, 0, 2, 0, 0, 2, 2, 2, 0, 2, 2, 0, 2, 2, 1, 2, 0, 0, 2, 0, 0, 0, 2, 0},
                                                            {0, 0, 2, 0, 0, 0, 2, 2, 2, 0, 2, 2, 2, 0, 0, 2, 0, 0, 0, 2, 1, 2, 2, 0, 2, 0, 2, 0, 0, 2, 2, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0},
                                                            {0, 0, 0, 0, 0, 2, 2, 0, 2, 0, 0, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 1, 2, 0, 0, 0, 0, 1, 0, 2, 0, 0, 2, 0, 1, 0, 0},
                                                            {1, 2, 0, 2, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 1, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 2, 0, 0, 0, 2, 0, 0, 1, 0, 2, 2},
                                                            {1, 0, 0, 2, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 2, 2, 0, 2, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                                                            {0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 1, 2, 2, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 2, 0, 1},
                                                            {2, 0, 0, 1, 1, 0, 1, 0, 2, 0, 0, 2, 1, 0, 2, 0, 0, 2, 2, 0, 2, 0, 2, 2, 0, 1, 2, 0, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0},
                                                            {2, 2, 0, 0, 0, 2, 2, 0, 2, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 2, 2, 0, 2, 0, 0, 2, 0, 2}}));
    }

    int m, n;

    public int shortestDistance(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int totalBuildings = 0;
        int[][] distances = new int[m][n];
        int[][] reached = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    totalBuildings++;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    bfs(grid, distances, reached, i, j);
                    if (reached[i][j] != totalBuildings) return -1;
                }
            }
        }
        int shortestDistance = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && reached[i][j] == totalBuildings && distances[i][j] < shortestDistance) {
                    shortestDistance = distances[i][j];
                }
            }
        }
        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }

    int[][] adjs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private void bfs(int[][] grid, int[][] distances, int[][] reached, int x, int y) {
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        int level = 1;
        reached[x][y] = 1;
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                int[] cell = queue.poll();
                for (int[] adj : adjs) {
                    int newX = cell[0] + adj[0];
                    int newY = cell[1] + adj[1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n &&
                            !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        if (grid[newX][newY] == 0) {
                            queue.add(new int[]{newX, newY});
                            distances[newX][newY] += level;
                            reached[newX][newY] += 1;
                        } else if (grid[newX][newY] == 1) {
                            reached[x][y] += 1;
                        }

                    }
                }
            }
            level++;
        }
    }


}
