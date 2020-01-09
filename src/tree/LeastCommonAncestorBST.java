package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Leet Code Problem Number : 235
 */
public class LeastCommonAncestorBST {

	public static void main(String[] args) {
		TreeNode a = new TreeNode(3);
		TreeNode b = new TreeNode(-1);
		TreeNode c = new TreeNode(5);
		TreeNode d = new TreeNode(-2);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(4);
		TreeNode g = new TreeNode(8);
		TreeNode h = new TreeNode(1);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		e.left = h;
		System.out.println(new LeastCommonAncestor().lca(a, f, h));
	}

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		List<TreeNode> pPath = new ArrayList<>();
		List<TreeNode> qPath = new ArrayList<>();
		findPath(root, p, pPath);
		findPath(root, q, qPath);
		for (int i = 1; i < Math.min(pPath.size(), qPath.size()); i++) {
			if (!pPath.get(i).equals(qPath.get(i))) {
				return pPath.get(i - 1);
			}
		}
		return pPath.size() < qPath.size() ? pPath.get(pPath.size() - 1) : qPath.get(qPath.size() - 1);
	}

	private void findPath(TreeNode root, TreeNode p, List<TreeNode> pPath) {
		pPath.add(root);
		if (root.equals(p)) {
			return;
		} else if (root.left != null && root.val > p.val) {
			findPath(root.left, p, pPath);
		} else if (root.right != null && root.val < p.val) {
			findPath(root.right, p, pPath);
		}
	}
}
