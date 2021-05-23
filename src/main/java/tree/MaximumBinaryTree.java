package tree;

public class MaximumBinaryTree {

	// leetcode problem: 654
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length - 1);
	}

	TreeNode constructMaximumBinaryTree(int[] nums, int a, int b) {
		if (a > b)
			return null;
		int maxIndex = a;
		int maxValue = nums[a];
		for (int i = a + 1; i <= b; i++) {
			if (nums[i] > maxValue) {
				maxValue = nums[i];
				maxIndex = i;
			}
		}
		TreeNode t = new TreeNode(maxValue);
		t.left = constructMaximumBinaryTree(nums, a, maxIndex - 1);
		t.right = constructMaximumBinaryTree(nums, maxIndex + 1, b);
		return t;
	}
}
