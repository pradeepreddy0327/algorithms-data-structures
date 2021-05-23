package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// lc 1192
public class StronglyConnected {

    public static void main(String[] args) {
        StronglyConnected obj = new StronglyConnected();
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0,1));
        connections.add(Arrays.asList(1,2));
        connections.add(Arrays.asList(2,0));
        connections.add(Arrays.asList(1,3));
        System.out.println(obj.criticalConnections(4, connections));

    }

    public List<List<Integer>> criticalConnections(int n,
            List<List<Integer>> connections) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (List<Integer> edge : connections) {
            graph[edge.get(0)].add(edge.get(1));
            graph[edge.get(1)].add(edge.get(0));
        }
        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1);
        for (int i = 0; i < n; i++) {
            if (disc[i] == -1) {
                bfs(i, graph, res, disc, low, -1);
            }
        }
        return res;
    }

    int time = 0;

    private void bfs(int u, List<Integer>[] graph, List<List<Integer>> res,
            int[] disc, int[] low, int pre) {
        disc[u] = low[u] = ++time;
        for (Integer v : graph[u]) {
            if (v != pre) {
                if (disc[v] == -1) {
                    bfs(v, graph, res, disc, low, u);
                    low[u] = Math.min(low[u], low[v]);
                    if (low[v] > disc[u]) {
                        res.add(Arrays.asList(u, v));
                    }
                } else {
                    low[u] = Math.min(low[u], low[v]);
                }
            }
        }
    }

}
