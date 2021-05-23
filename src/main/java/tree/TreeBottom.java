package tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeBottom {

	public static void main(String[] args) {
		TreeBottom obj = new TreeBottom();
		System.out.println(Arrays.toString(obj.treeBottom("(1 () ())")));
	}

	List<Integer> b;
	int maxLvl = -1;

	int[] treeBottom(String tree) {
		b = new ArrayList<Integer>();
		getNode(tree, 0);
		int[] ans = new int[b.size()];
		int i = 0;
		for (Integer j : b) {
			ans[i++] = j;
		}
		return ans;
	}

	void getNode(String tree, int lvl) {
		if (tree.equals("()"))
			return;
		tree = tree.substring(1, tree.length() - 1);
		int val = Integer.valueOf(tree.substring(0, tree.indexOf(" ")));
		if (lvl > maxLvl) {
			maxLvl = lvl;
			b = new ArrayList<Integer>();
			b.add(val);
		} else if (lvl == maxLvl) {
			b.add(val);
		}
		tree = tree.substring(tree.indexOf(" ") + 1);
		int o = 0;
		int leftEnd = 0;
		for (int i = 0; i < tree.length(); i++) {
			if (tree.charAt(i) == '(')
				o++;
			else if (tree.charAt(i) == ')')
				o--;
			if (o == 0) {
				leftEnd = i;
				break;
			}
		}
		getNode(tree.substring(0, leftEnd + 1), lvl + 1);
		getNode(tree.substring(leftEnd + 2), lvl + 1);
	}

}
