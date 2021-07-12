package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

// leetcode 133 tags: Facebook
public class CloneGraph {
    Map<Node, Node> visited = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        visited.put(node, clone);
        for(Node neighbor: node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;
    }

    public Node cloneGraphBFS(Node node) {
        if(node == null) return null;
        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node nodeClone = new Node(node.val, new ArrayList<>());
        visited.put(node, nodeClone);
        queue.add(node);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            Node currentClone = visited.get(current);
            for(Node neighbor: current.neighbors){
                if(!visited.containsKey(neighbor)){
                    Node neighborClone = new Node(neighbor.val, new ArrayList<>());
                    visited.put(neighbor, neighborClone);
                    queue.add(neighbor);
                }
                currentClone.neighbors.add(visited.get(neighbor));
            }
        }
        return nodeClone;
    }

    class Node {
        public int        val;
        public List<Node> neighbors;
        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }
        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}

