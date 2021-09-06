package graph;

import tree.TreeDiameterV2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GraphDiameter {

    public static void main(String[] args) {
        TreeDiameterV2 obj = new TreeDiameterV2();
        System.out.println(obj.treeDiameter(new int[][] {{0,1},{0,2}}));
    }

    public int treeDiameter(int[][] edges){
        Map<Integer, List<Integer>> adjListMap = new HashMap<>();
        for(int[] edge:edges){
            for(int i=0;i<2;i++){
                List<Integer> adjList = adjListMap.getOrDefault(edge[i], new ArrayList<>());
                adjList.add(edge[(i+1)%2]);
                adjListMap.putIfAbsent(edge[i], adjList);
            }
        }
        int[] nodeDistance = bfs(edges[0][0], adjListMap);
        int[] maxDistance = bfs(nodeDistance[0], adjListMap);
        return maxDistance[1];
    }

    private int[] bfs(int start, Map<Integer, List<Integer>> adjListMap) {
        Map<Integer, Integer> distanceMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        distanceMap.put(start, 0);
        int end = start;
        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int adj: adjListMap.get(current)){
                if(!distanceMap.containsKey(adj)){
                    distanceMap.put(adj, distanceMap.get(current)+1);
                    queue.add(adj);
                    end = adj;
                }
            }
        }
        return new int[]{end, distanceMap.get(end)};
    }
}
