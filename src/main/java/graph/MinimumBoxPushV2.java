package graph;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MinimumBoxPushV2 {
    public static void main(String[] args) {
        MinimumBoxPushV2 obj = new MinimumBoxPushV2();
        System.out.println(obj.minPushBox(new char[][]{{'#','#','#','#','#','#'},
                                                       {'#','T','#','#','#','#'},
                                                       {'#','.','.','B','.','#'},
                                                       {'#','.','#','#','.','#'},
                                                       {'#','.','.','.','S','#'},
                                                       {'#','#','#','#','#','#'}}));
        System.out.println(obj.minPushBox(new char[][]{{'#','#','#','#','#','#'},
                                                       {'#','T','#','#','#','#'},
                                                       {'#','.','.','B','.','#'},
                                                       {'#','#','#','#','.','#'},
                                                       {'#','.','.','.','S','#'},
                                                       {'#','#','#','#','#','#'}}));
        System.out.println(obj.minPushBox(new char[][]{{'#','#','#','#','#','#'},
                                                       {'#','T','.','.','#','#'},
                                                       {'#','.','#','B','.','#'},
                                                       {'#','.','.','.','.','#'},
                                                       {'#','.','.','.','S','#'},
                                                       {'#','#','#','#','#','#'}}));

        System.out.println(obj.minPushBox(new char[][]{{'#','.','.','#','#','#','#','#'},
                                                       {'#','.','.','T','#','.','.','#'},
                                                       {'#','.','.','.','#','B','.','#'},
                                                       {'#','.','.','.','.','.','.','#'},
                                                       {'#','.','.','.','#','.','S','#'},
                                                       {'#','.','.','#','#','#','#','#'}}));

        System.out.println(obj.minPushBox(new char[][]{{'#','.','.','#','T','#','#','#','#'},
                                                       {'#','.','.','#','.','#','.','.','#'},
                                                       {'#','.','.','#','.','#','B','.','#'},
                                                       {'#','.','.','.','.','.','.','.','#'},
                                                       {'#','.','.','.','.','#','.','S','#'},
                                                       {'#','.','.','#','.','#','#','#','#'}}));
    }
    private int[][] adjPoints = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] startingPosition = new int[6];
        int[] target = new int[2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    startingPosition[0] = i;
                    startingPosition[1] = j;
                } else if (grid[i][j] == 'B') {
                    startingPosition[2] = i;
                    startingPosition[3] = j;
                } else if (grid[i][j] == 'T') {
                    target[0] = i;
                    target[1] = j;

                }
            }
        }
        startingPosition[4] = dist(startingPosition[0], startingPosition[1], target);
        startingPosition[5] = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[4]));
        q.add(startingPosition);
        Set<String> moveSet = new HashSet<>();
        while (!q.isEmpty()) {
            int[] p = q.poll();
            if (grid[p[2]][p[3]] == 'T') return p[5];
            String ss = p[0]+":"+p[1]+"|"+p[2]+":"+p[3];
            if(moveSet.contains(ss)) continue;
            moveSet.add(ss);
            for (int[] adj : adjPoints) {
                int npx = p[0] + adj[0];
                int npy = p[1] + adj[1];
                int nbx = p[2] + adj[0];
                int nby = p[3] + adj[1];
                if (isValid(npx, npy, m, n, grid) ) {
                    if (npx == p[2] && npy == p[3]) {
                        if (!isValid(nbx, nby, m, n, grid)) continue;
                        q.add(new int[]{npx, npy, nbx, nby, dist(nbx, nby, target) + p[5] + 1, p[5] + 1});
                    } else {
                        q.add(new int[]{npx, npy, p[2], p[3], p[4], p[5]});
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValid(int x, int y, int m, int n, char[][] grid) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != '#';
    }

    private int dist(int x, int y, int[] target) {
        return Math.abs(target[0] - x) + Math.abs(target[1] - y);
    }
}
