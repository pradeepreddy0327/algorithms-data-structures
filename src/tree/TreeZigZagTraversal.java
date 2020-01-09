package tree;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

//lc 106
public class TreeZigZagTraversal {

    public static void main(String[] args) {

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        LinkedHashMap<Integer, List<Integer>> levelMap = new LinkedHashMap<>();
        traverse(root, 0, levelMap);
        return new ArrayList<List<Integer>>(levelMap.values());
    }

    private void traverse(TreeNode node, int i,
            LinkedHashMap<Integer, List<Integer>> levelMap) {
        if (node != null) {
            List<Integer> l = levelMap.getOrDefault(i,
                    new ArrayList<Integer>());
            levelMap.put(i, l);
            if (i % 2 == 0) {
                l.add(node.val);
            } else {
                l.add(0, node.val);
            }
            traverse(node.left, i + 1, levelMap);
            traverse(node.right, i + 1, levelMap);
        }

    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
