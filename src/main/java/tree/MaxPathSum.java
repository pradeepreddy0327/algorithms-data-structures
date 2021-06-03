package tree;

// leetcode 124  tags: Facebook
public class MaxPathSum {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recur(root);
        return maxSum;
    }

    public int recur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(maxPathSum(root.left), 0);
        int right = Math.max(maxPathSum(root.right), 0);
        maxSum = Math.max(root.val + left + right, maxSum);
        return root.val + Math.max(left, right);
    }
}
