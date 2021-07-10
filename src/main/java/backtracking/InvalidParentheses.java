package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InvalidParentheses {

    public static void main(String[] args) {
        InvalidParentheses obj = new InvalidParentheses();
        System.out.println(obj.removeInvalidParentheses("()())()"));
    }

    public List<String> removeInvalidParentheses(String s) {
        int invalidClosedCount = 0;
        int invalidOpenCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                invalidOpenCount++;
            }
            if (c == ')') {
                if (invalidOpenCount > 0) {
                    invalidOpenCount--;
                } else {
                    invalidClosedCount++;
                }
            }
        }
        Set<String> ans = new HashSet<>();
        recurse(s, 0, "", 0, 0, invalidOpenCount, invalidClosedCount, ans);
        return new ArrayList<>(ans);
    }

    private void recurse(String s, int i, String current, int leftCount,
                         int rightCount, int leftRem,
                         int rightRem, Set<String> ans) {
        if (s.length() == i) {
            if (leftRem == 0 && rightRem == 0) {
                ans.add(current);
            }
            return;
        }
        if (s.charAt(i) == '(') {
            if (leftRem > 0) {
                recurse(s, i + 1, current, leftCount, rightCount,
                        leftRem - 1, rightRem, ans);
            }
            recurse(s, i + 1, current + s.charAt(i), leftCount + 1, rightCount,
                    leftRem, rightRem, ans);
        } else if (s.charAt(i) == ')') {
            if (rightRem > 0) {
                recurse(s, i + 1, current, leftCount, rightCount,
                        leftRem, rightRem - 1, ans);
            }
            if (leftCount > rightCount) {
                recurse(s, i + 1, current + s.charAt(i), leftCount, rightCount + 1,
                        leftRem, rightRem, ans);
            }
        } else {
            recurse(s, i + 1, current + s.charAt(i), leftCount, rightCount,
                    leftRem, rightRem, ans);
        }
    }
}
