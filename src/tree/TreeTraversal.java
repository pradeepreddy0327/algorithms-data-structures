package tree;

import java.util.ArrayList;
import java.util.List;

public class TreeTraversal {

	public static void main(String[] args) {
		TreeTraversal obj = new TreeTraversal();

		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		TreeNode g = new TreeNode(7);

		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		List<Integer> in = new ArrayList<>();
		List<Integer> pre = new ArrayList<>();
		List<Integer> post = new ArrayList<>();
		obj.inorder(a, in);
		obj.preorder(a, pre);
		obj.postOrder(a, post);

		System.out.println("in : " + in);
		System.out.println("pre : " + pre);
		System.out.println("post : " + post);

		TreeNode copy = obj.constructTree(new int[] { 4, 2, 5, 1, 6, 3, 7 }, new int[] { 4, 5, 2, 6, 7, 3, 1 }, 0, 7, 0,
				7);
		TreeNode copy2 = obj.constructTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 }, 0, 5, 0, 5);
		 System.out.println(a.equals(copy));
		// obj.testEquals();
	}

	private void inorder(TreeNode node, List<Integer> path) {
		if (node != null) {
			inorder(node.left, path);
			path.add(node.val);
			inorder(node.right, path);
		}
	}

	private void preorder(TreeNode node, List<Integer> path) {
		if (node != null) {
			path.add(node.val);
			preorder(node.left, path);
			preorder(node.right, path);
		}
	}

	private void postOrder(TreeNode node, List<Integer> path) {
		if (node != null) {
			postOrder(node.left, path);
			postOrder(node.right, path);
			path.add(node.val);
		}
	}

	private TreeNode constructTree(int[] inorder, int[] postorder, int ib, int ie, int pb, int pe) {
		System.out.println(" ib :" + ib + " ie :" + ie + " pb :" + pb + " pe :" + pe);
		if (ib < ie && pb < pe) {
			int val = postorder[pe - 1];
			TreeNode head = new TreeNode(val);
			int index = find(inorder, val);
			head.left = constructTree(inorder, postorder, ib, index, pb, pb + (index - ib));
			head.right = constructTree(inorder, postorder, index + 1, ie, pe -ie + index, pe - 1);
			return head;
		}
		return null;
	}

	private int find(int[] arr, int j) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == j)
				return i;
		}
		return -1;
	}

	private void testEquals() {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);

		TreeNode d = new TreeNode(1);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(3);

		a.left = b;
		a.right = c;

		d.left = e;
		d.right = f;
		System.out.println(a.equals(d));
	}

}
