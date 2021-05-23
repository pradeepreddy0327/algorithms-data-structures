package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Leet Code Problem Number : 236
 */
public class LeastCommonAncestor {

	public static void main(String[] args) {
		// [3,5,1,6,2,0,8,null,null,7,4];
//		TreeNode a = new TreeNode(3);
//		TreeNode b = new TreeNode(5);
//		TreeNode c = new TreeNode(1);
//		TreeNode d = new TreeNode(6);
//		TreeNode e = new TreeNode(2);
//		TreeNode f = new TreeNode(0);
//		TreeNode g = new TreeNode(8);
//		TreeNode h = new TreeNode(7);
//		TreeNode i = new TreeNode(4);
//		a.left = b;
//		a.right = c;
//		b.left = d;
//		b.right = e;
//		c.left = f;
//		c.right = g;
//		e.left = h;
//		e.right = i;
		
		TreeNode a = new TreeNode(37);
		TreeNode b = new TreeNode(-34);
		TreeNode c = new TreeNode(-48);
		TreeNode d = new TreeNode(-100);
		TreeNode e = new TreeNode(-101);
		TreeNode f = new TreeNode(48);
		TreeNode g = new TreeNode(-54);
		TreeNode h = new TreeNode(-71);
		TreeNode i = new TreeNode(-22);
		TreeNode j = new TreeNode(8);
		a.left = b;
		a.right = c;
		b.right = d;
		c.left = e;
		c.right = f;
		f.left = g;
		g.left = h;
		g.right = i;
		i.right = j;
		System.out.println(new LeastCommonAncestor().lca(a, f, h));
	}

	public TreeNode lca(TreeNode head, TreeNode p, TreeNode q) {

		List<TreeNode> pPath = new ArrayList<>();
		List<TreeNode> qPath = new ArrayList<>();

		findPath(head, p, pPath);
		findPath(head, q, qPath);
		for (int i = 0; i < Math.min(pPath.size(), qPath.size()); i++) {
			if (!pPath.get(i).equals(qPath.get(i))) {
				return pPath.get(i - 1);
			}
		}
		return pPath.size() < qPath.size() ? pPath.get(pPath.size() - 1) : qPath.get(qPath.size() - 1);
	}

	private boolean findPath(TreeNode node, TreeNode p, List<TreeNode> pPath) {
		pPath.add(node);
		if (node.equals(p)) {
			return true;
		}
		if (node.left != null && findPath(node.left, p, pPath)) {
			return true;
		}
		if (node.right != null && findPath(node.right, p, pPath)) {
			return true;
		}
		pPath.remove(pPath.size() - 1);
		return false;
	}
}

