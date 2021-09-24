package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class ShortestDistanceWithObstacles {
    public static void main(String[] args) {
        ShortestDistanceWithObstacles obj = new ShortestDistanceWithObstacles();
        System.out.println(obj.shortestPath(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1));
    }

    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int shortestPath(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<State> q = new LinkedList<>();
        Set<State> seen = new HashSet<>();
        State start = new State(0, 0, 0, k);
        q.add(start);
        seen.add(start);
        while (!q.isEmpty()) {
            State currentState = q.poll();
            for (int[] direction : directions) {
                int newRow = currentState.row + direction[0];
                int newColumn = currentState.column + direction[1];
                if (newRow >= 0 && newRow < m && newColumn >= 0 && newColumn < n) {
                    int nextK = currentState.k - grid[newRow][newColumn];
                    State newState = new State(newRow, newColumn, currentState.steps + 1, nextK);
                    if (nextK >= 0 && !seen.contains(newState)) {
                        if (newRow == m - 1 && newColumn == n - 1) {
                            return newState.steps;
                        }
                        q.add(newState);
                        seen.add(newState);
                    }
                }
            }
        }
        return -1;
    }

    class State {
        int row;
        int column;
        int steps;
        int k;

        public State(int row, int column, int steps, int k) {
            this.row = row;
            this.column = column;
            this.steps = steps;
            this.k = k;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return row == state.row && column == state.column && k == state.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column, k);
        }
    }
}
