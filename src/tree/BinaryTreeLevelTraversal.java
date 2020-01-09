package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeLevelTraversal {

	
	// leet code 102
	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(9);
		TreeNode c = new TreeNode(20);
		TreeNode d = new TreeNode(15);
		TreeNode e = new TreeNode(7);
//		TreeNode f = new TreeNode(48);
//		TreeNode g = new TreeNode(-54);
//		TreeNode h = new TreeNode(-71);
//		TreeNode i = new TreeNode(-22);
//		TreeNode j = new TreeNode(8);
		a.left = b;
		a.right = c;
		c.left = d;
		c.right =e;
		System.out.println(new BinaryTreeLevelTraversal().levelOrder(a));

	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
        traverse(root,ans,0);
        return ans;
    }
    public void traverse(TreeNode node,List<List<Integer>> ans, int level){
        if(node != null){
            List<Integer> l = ans.size()>level?ans.get(level):null;
            if(l==null){
                l = new ArrayList<Integer>();
                ans.add(l);
            }
            l.add(node.val);
            traverse(node.left,ans,level+1);
            traverse(node.right,ans,level+1);
        }
    }

}
