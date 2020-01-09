package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

// lc 210 --- 207
public class CourseSchedule {

    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();
        System.out.println(Arrays.toString(
                obj.findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 },
                        { 3, 2 } })));
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Integer> incomingEdges = new HashMap<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            incomingEdges.put(i, 0);
            graph.put(i, new ArrayList<Integer>());
        }
        for (int[] dep : prerequisites) {
            graph.get(dep[1]).add(dep[0]);
            incomingEdges.put(dep[0], incomingEdges.get(dep[0]) + 1);
        }
        int[] courseOrder = new int[numCourses];
        int i = 0;
        Queue<Integer> q = new LinkedList<>();
        for (Entry<Integer, Integer> entry : incomingEdges.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }
        while (!q.isEmpty()) {
            Integer vertex = q.poll();
            courseOrder[i++] = vertex;
            for (Integer adj : graph.get(vertex)) {
                incomingEdges.put(adj, incomingEdges.get(adj) - 1);
                if (incomingEdges.get(adj) == 0) {
                    q.add(adj);
                }
            }
        }
        return i == numCourses ? courseOrder : new int[0];
    }
}
