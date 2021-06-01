package tree.bst;

// leetcode 426  tags: Facebook
public class BSTToSortedDoublyLinkedList {
    public static void main(String[] args) {

    }

    private Node dummyHead;
    private Node current;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dummyHead = new Node(-1);
        current = dummyHead;
        traverse(root);
        current.right = dummyHead.right;
        dummyHead.right.left = current;
        return dummyHead.right;
    }

    private void traverse(Node node){
        if(node == null) return;
        traverse(node.left);
        current.right = node;
        node.left = current;
        current = node;
        traverse(node.right);
    }

}
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}
