package tree;

public class FlattenTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
//		TreeNode g = new TreeNode(-54);
//		TreeNode h = new TreeNode(-71);
//		TreeNode i = new TreeNode(-22);
//		TreeNode j = new TreeNode(8);
		a.left = b;
		b.left = c;
		b.right =d;
		a.right = e;
		e.right = f;
		TreeNode ans = new FlattenTree().inorder(a);
		System.out.println(ans);
		System.out.println((int)'A');
	}
	
	public TreeNode inorder(TreeNode node){
        if(node != null){
            TreeNode left = inorder(node.left);
            node.left = null;
            TreeNode right = inorder(node.right);
            node.right = left!=null?left:right;
            if(left != null) {
            	while(left.right!=null) {
            		left = left.right;
            	}
            	left.right = right;
            }
            return node;
        }
        return null;
    }

}
