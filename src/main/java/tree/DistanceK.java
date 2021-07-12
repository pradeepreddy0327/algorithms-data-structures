package tree;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// Leetcode 863 Tags: Facebook
public class DistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> result = new ArrayList<>();
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        //populate parentMap
        populateParentMap(root, null, parentMap);

        // bfs
        Set<TreeNode> visited = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(target);
        visited.add(target);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i =0;i<size;i++){
                TreeNode node = queue.poll();
                if(level == k) {
                    result.add(node.val);
                    continue;
                }
                TreeNode parent = parentMap.get(node);
                addToQueue(visited, queue, parent);
                addToQueue(visited, queue, node.left);
                addToQueue(visited, queue, node.right);

            }
            level++;
        }
        return result;
    }

    private void addToQueue(Set<TreeNode> visited, Queue<TreeNode> queue,TreeNode node) {
        if (node != null && !visited.contains(node)) {
                visited.add(node);
                queue.add(node);
        }
    }

    private void populateParentMap(TreeNode node, TreeNode parent, Map<TreeNode, TreeNode> parentMap) {
        if(node != null) {
            parentMap.put(node, parent);
            populateParentMap(node.left, node, parentMap);
            populateParentMap(node.right, node, parentMap);
        }
    }

}
