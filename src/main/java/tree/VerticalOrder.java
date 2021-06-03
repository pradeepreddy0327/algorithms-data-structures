package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

// leetcode 314  tags: Facebook
public class VerticalOrder {

    public static void main(String[] args) {
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Map<Integer, List<Integer>> levelMap = new HashMap<>();
        Queue<TreeNodeLevel> q = new LinkedList<>();
        q.add(new TreeNodeLevel(root, 0));
        int minLevel = 0;
        int maxLevel = 0;
        while(!q.isEmpty()){
            TreeNodeLevel nodeLevel = q.poll();
            List<Integer> list = levelMap.get(nodeLevel.level);
            if(list == null){
                list = new ArrayList<>();
                levelMap.put(nodeLevel.level, list);
            }
            list.add(nodeLevel.node.val);

            if(nodeLevel.node.left != null){
                q.add(new TreeNodeLevel(nodeLevel.node.left, nodeLevel.level-1));
                minLevel = Math.min(minLevel, nodeLevel.level-1);
            }
            if(nodeLevel.node.right != null){
                q.add(new TreeNodeLevel(nodeLevel.node.right, nodeLevel.level+1));
                maxLevel = Math.max(maxLevel, nodeLevel.level+1);
            }
        }

        for(int i = minLevel; i<= maxLevel; i++){
            ans.add(levelMap.get(i));
        }
        return ans;
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
