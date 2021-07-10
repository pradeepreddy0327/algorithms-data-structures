package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerticalOrderTraversalV2 {
    int minY;
    int maxY;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        minY = 0;
        maxY = 0;
        Map<Integer, List<int[]>> vertLevelMap = new HashMap<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        dfs(root, vertLevelMap, 0, 0);
        for(int i=minY;i<=maxY;i++){
            List<int[]> levelList = vertLevelMap.get(i);
            Collections.sort(levelList, (a,b)-> {
                if(a[0]!=b[0]) return a[0]-b[0];
                return a[1]-b[1];
            });
            List<Integer> level = new ArrayList<>();
            for(int[] elem: levelList){
                level.add(elem[1]);
            }
            ans.add(level);
        }
        return ans;
    }

    private void dfs(TreeNode node, Map<Integer, List<int[]>> vertLevelMap, int x, int y) {
        minY = Math.min(minY, y);
        maxY = Math.max(maxY, y);
        List<int[]> levelList = vertLevelMap.getOrDefault(y, new ArrayList<>());
        levelList.add(new int[]{x, node.val});
        vertLevelMap.putIfAbsent(y, levelList);
        if(node.left != null){
            dfs(node.left, vertLevelMap, x+1, y-1);
        }
        if(node.right != null){
            dfs(node.right, vertLevelMap, x+1, y+1);
        }
    }

}
