package tree;

import javax.xml.stream.events.Characters;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Str2Tree {

    public static void main(String[] args) {
        Str2Tree obj = new Str2Tree();
        TreeNode node = obj.str2treeV2("");
        System.out.println(node);
    }
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        StringBuilder currentNumber = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '-' || Character.isDigit(c)){
                currentNumber.append(c);
            } else if(c == '('){
                if(currentNumber.length() != 0){
                    stack.add(new TreeNode(Integer.valueOf(currentNumber.toString())));
                    currentNumber = new StringBuilder();
                }
            } else if(c == ')'){
                if(currentNumber.length() != 0){
                    stack.add(new TreeNode(Integer.valueOf(currentNumber.toString())));
                    currentNumber = new StringBuilder();
                }
                TreeNode node = stack.pop();
                TreeNode parent = stack.peek();
                if(parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }
        }
        if(currentNumber.length() != 0){
            stack.add(new TreeNode(Integer.valueOf(currentNumber.toString())));
        }
        return stack.isEmpty() ? null : stack.pop();
    }
    public TreeNode str2treeV2(String s) {
        return recurse(s,0).node;
    }

    private NodeIndex recurse(String s, int i){
        if(i >= s.length()) return new NodeIndex(null, i);
        if(s.charAt(i) == '('){
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(i<s.length() && s.charAt(i) != '(' && s.charAt(i) != ')'){
            sb.append(s.charAt(i++));
        }
        TreeNode node = null;
        if(sb.length() != 0){
            node = new TreeNode(Integer.valueOf(sb.toString()));
        }
        if(i<s.length() && s.charAt(i) == '('){
            NodeIndex ni = recurse(s, i);
            node.left = ni.node;
            i = ni.index;
        }
        if(i<s.length() && s.charAt(i) == '('){
            NodeIndex ni = recurse(s, i);
            node.right = ni.node;
            i = ni.index;
        }
        if(i<s.length() && s.charAt(i) == ')'){
            i++;
        }
        return new NodeIndex(node, i);
    }

    class NodeIndex{
        TreeNode node;
        int index;
        NodeIndex(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

}
