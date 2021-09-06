package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeDiameterV2 {

    public static void main(String[] args) {
        TreeDiameterV2 obj = new TreeDiameterV2();
        System.out.println(obj.treeDiameter(new int[][]{{0, 1}, {0, 2}}));
        System.out.println(obj.treeDiameter(new int[][]{{0, 1}, {1,2},{2,3},{1,4},{4,5}}));
    }

    int diameter = 0;

    public int treeDiameter(int[][] edges) {
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();
        for (int[] edge : edges) {
            for (int i = 0; i < 2; i++) {
                List<Integer> adjList = adjListMap.getOrDefault(edge[i], new ArrayList<>());
                adjList.add(edge[(i + 1) % 2]);
                adjListMap.putIfAbsent(edge[i], adjList);
            }
        }
        dfs(edges[0][0], adjListMap, -1);
        return diameter;
    }

    private int dfs(int node, Map<Integer, List<Integer>> adjListMap, int parent) {
        int max1 = 0;
        int max2 = 0;
        for (int adj : adjListMap.get(node)) {
            if (adj != parent) {
                int dist = dfs(adj, adjListMap, node) + 1;
                if (dist > max1) {
                    max2 = max1;
                    max1 = dist;
                } else if (dist > max2) {
                    max2 = dist;
                }
            }
        }
        diameter = Math.max(diameter, max1 + max2);
        return max1;
    }


}
