package tree;

import java.util.Arrays;

// leet code : 297
public class BinaryTreeSerializeDeserialize {
    int i=0;
	public static void main(String[] args) {
		BinaryTreeSerializeDeserialize obj = new BinaryTreeSerializeDeserialize();
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		// TreeNode f = new TreeNode(48);
		// TreeNode g = new TreeNode(-54);
		// TreeNode h = new TreeNode(-71);
		// TreeNode i = new TreeNode(-22);
		// TreeNode j = new TreeNode(8);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		StringBuilder sb = new StringBuilder();
		obj.s2(a, sb);
		String ser = sb.toString().substring(1);
		System.out.println(ser);
		TreeNode des = obj.ds2(ser.split(","));
		System.out.println(des);
		System.out.println(des.equals(a));
	}

	int size = 0;

	private void s2(TreeNode root, StringBuilder s) {
		if (root == null) {
			s.append(",#");
			return;
		}
		s = s.append("," + root.val);
		s2(root.left, s);
		s2(root.right, s);
	}

	private TreeNode ds2(String[] s) {
		String k = s[i++];
		if (k.equals("#")) {
			return null;
		}
		TreeNode node = new TreeNode(Integer.valueOf(k));
		node.left = ds2(s);
		node.right = ds2(s);
		return node;
	}

}
