package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class VerticalOrderTraversal {

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<int[]>> vertLevelMap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNodeWithLevel> queue = new LinkedList<>();
        queue.add(new TreeNodeWithLevel(root, 0, 0));
        int minLevel = 0;
        int maxLevel = 0;
        while (!queue.isEmpty()) {
            TreeNodeWithLevel nodeWithLevel = queue.poll();
            int[] nodeLevelAndVal = new int[]{nodeWithLevel.x, nodeWithLevel.node.val};
            List<int[]> nodeLevelAndValueList = vertLevelMap.getOrDefault(nodeWithLevel.y, new ArrayList<>());
            insert(nodeLevelAndValueList, nodeLevelAndVal);
            vertLevelMap.putIfAbsent(nodeWithLevel.y, nodeLevelAndValueList);
            if (nodeWithLevel.node.left != null) {
                queue.add(new TreeNodeWithLevel(nodeWithLevel.node.left, nodeWithLevel.x + 1, nodeWithLevel.y - 1));
                minLevel = Math.min(minLevel, nodeWithLevel.y - 1);
            }
            if (nodeWithLevel.node.right != null) {
                queue.add(new TreeNodeWithLevel(nodeWithLevel.node.right, nodeWithLevel.x + 1, nodeWithLevel.y + 1));
                maxLevel = Math.max(maxLevel, nodeWithLevel.y + 1);
            }
        }
        for (int i = minLevel; i <= maxLevel; i++) {
            List<int[]> valueList = vertLevelMap.get(i);
            List<Integer> l = new ArrayList<>();
            for (int[] value : valueList) {
                l.add(value[1]);
            }
            ans.add(l);
        }
        return ans;
    }

    private void insert(List<int[]> list, int[] val){
        if(list.size() == 0){
            list.add(val);
        } else{
            for(int i = list.size()-1;i>=0;i--){
                int[] elem = list.get(i);
                if(elem[0]==val[0] && elem[1]>val[1]){
                    continue;
                }
                list.add(i, val);
                break;
            }
        }
    }
    class TreeNodeWithLevel {
        TreeNode node;
        int      x;
        int      y;

        TreeNodeWithLevel(TreeNode node, int x, int y) {
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
}
