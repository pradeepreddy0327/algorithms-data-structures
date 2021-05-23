package stack;

import java.util.Stack;

public class ValidParanthesis {
    // leetcode problem 20
    public static void main(String[] args) {

        ValidParanthesis obj = new ValidParanthesis();
        System.out.println(obj.changes("))(()))"));
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty())
                    return false;
                char p = stack.pop();
                if (!((p == '{' && c == '}') || (p == '[' && c == ']')
                        || (p == '(' && c == ')'))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public int changes(String s) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    count++;
                    continue;
                }
                stack.pop();
            }
        }
        return count + stack.size();
    }

}
