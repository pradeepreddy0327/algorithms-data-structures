package stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LongestValidParanthesis {

    public static void main(String[] args) {
        LongestValidParanthesis obj = new LongestValidParanthesis();
        System.out.println(obj.longestValidParentheses("(()"));
        System.out.println(obj.longestValidParentheses(")()())"));

    }

    public int longestValidParentheses(String s) {
        char[] sc = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> lengthMap = new HashMap<>();
        int maxL = 0;
        for (int i = 0; i < sc.length; i++) {
            if (sc[i] == '(') {
                stack.add(i);
            } else {
                if (!stack.empty()) {
                    int j = stack.pop();
                    int prevL = lengthMap.containsKey(j - 1)
                            ? lengthMap.get(j - 1)
                            : 0;
                    int l = prevL + i - j + 1;
                    lengthMap.put(i, l);
                    maxL = Math.max(maxL, l);
                } else {
                    lengthMap.clear();
                }
            }

        }
        return maxL;
    }
}
