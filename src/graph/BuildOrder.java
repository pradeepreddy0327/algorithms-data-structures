package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public class BuildOrder {

    public static void main(String[] args) {
        BuildOrder obj = new BuildOrder();
        System.out.println(
                obj.buildOrder(new Character[] { 'a', 'b', 'c', 'd', 'e', 'f' },
                        new Character[][] { { 'a', 'd' }, { 'f', 'b' },
                                { 'b', 'd' }, { 'f', 'a' }, { 'd', 'c' } }));
    }

    public List<Character> buildOrder(Character[] projects,
            Character[][] dependecies) {
        Map<Character, Integer> incomingEdges = new HashMap<>();
        Map<Character, List<Character>> graph = new HashMap<>();
        for (Character p : projects) {
            incomingEdges.put(p, 0);
            graph.put(p, new ArrayList<Character>());
        }
        for (Character[] dep : dependecies) {
            graph.get(dep[0]).add(dep[1]);
            incomingEdges.put(dep[1], incomingEdges.get(dep[1]) + 1);
        }
        List<Character> buildOrder = new ArrayList<Character>();
        Queue<Character> q = new LinkedList<>();
        for (Entry<Character, Integer> entry : incomingEdges.entrySet()) {
            if (entry.getValue() == 0) {
                q.add(entry.getKey());
            }
        }
        while (!q.isEmpty()) {
            Character vertex = q.poll();
            buildOrder.add(vertex);
            for (Character adj : graph.get(vertex)) {
                incomingEdges.put(adj, incomingEdges.get(adj) - 1);
                if (incomingEdges.get(adj) == 0) {
                    q.add(adj);
                }
            }
        }
        return buildOrder.size() == projects.length ? buildOrder : null;
    }

}
