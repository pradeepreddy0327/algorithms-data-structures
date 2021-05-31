package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CBTInserter {
    List<TreeNode> list;

    public CBTInserter(TreeNode root) {
        list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode parent = list.get((list.size() - 1) / 2);
        if (list.size() % 2 == 0) parent.right = node;
        else parent.left = node;
        list.add(node);
        return parent.val;
    }

    public TreeNode get_root() {
        return list.get(0);
    }

}

class CBTInserterV2 {
    Queue<TreeNode> nonCompleteNodes;
    TreeNode root;
    public CBTInserterV2(TreeNode root) {
        this.root = root;
        nonCompleteNodes = new LinkedList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(node.left == null ||node.right == null) nonCompleteNodes.add(node);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
        }
    }

    public int insert(int v) {
        TreeNode node = new TreeNode(v);
        TreeNode parent = nonCompleteNodes.peek();
        nonCompleteNodes.add(node);
        if(parent.left == null) parent.left = node;
        else if(parent.right == null){
            parent.right = node;
            nonCompleteNodes.poll();
        }
        return parent.val;
    }

    public TreeNode get_root() {
        return root;
    }
}