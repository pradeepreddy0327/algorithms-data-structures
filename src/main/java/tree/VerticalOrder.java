package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

// lc 314
public class VerticalOrder {

    public static void main(String[] args) {
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<TreeNodeLevel> q = new LinkedList<>();
        if (root != null) {
            q.add(new TreeNodeLevel(root, 0));
        }
        while (!q.isEmpty()) {
            TreeNodeLevel nodeLevel = q.poll();
            List<Integer> list = map.getOrDefault(nodeLevel.level,
                    new ArrayList<Integer>());
            map.put(nodeLevel.level, list);
            list.add(nodeLevel.node.val);
            if (nodeLevel.node.left != null) {
                q.add(new TreeNodeLevel(nodeLevel.node.left, nodeLevel.level-1));
            }
            if (nodeLevel.node.right != null) {
                q.add(new TreeNodeLevel(nodeLevel.node.right,
                        nodeLevel.level + 1));
            }
        }
        return new ArrayList<>(map.values());
    }

    class TreeNodeLevel {
        TreeNode node;
        int level;

        TreeNodeLevel(TreeNode node, int level) {
            super();
            this.node = node;
            this.level = level;
        }
    }

}
