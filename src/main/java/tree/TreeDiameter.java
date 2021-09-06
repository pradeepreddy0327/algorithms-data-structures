package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeDiameter {

    int max = 0;

    public int diameter(Node root) {
        dfs(root);
        return max;
    }

    private int dfs(Node node) {
        if (node == null) return 0;
        int firstMax = 0;
        int secondMax = 0;
        for (Node child : node.children) {
            int current = dfs(child) + 1;
            if (current > firstMax) {
                secondMax = firstMax;
                firstMax = current;
            } else if (current > secondMax) {
                secondMax = current;
            }
        }
        max = Math.max(max, firstMax + secondMax);
        return firstMax;
    }

    class Node {
        public int        val;
        public List<Node> children;


        public Node() {
            children = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}
