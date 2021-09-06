package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class BraceExpressions {

    public static void main(String[] args) {
        BraceExpressions obj = new BraceExpressions();
        System.out.println(obj.braceExpansionII("a,b,c"));
        System.out.println(obj.braceExpansionII("{{a,b},{b,c}}"));
        System.out.println(obj.braceExpansionII("{a,b}{c,d}"));
        System.out.println(obj.braceExpansionII("a{b,c}{d,e}f{g,h}"));
    }


    public List<String> braceExpansionII(String expression) {
        int i = 0;
        Stack<List<String>> stack = new Stack<>();
        char preSign = '+';
        while (i < expression.length()) {
            if (expression.charAt(i) == '{') {
                int j = i + 1;
                int p = 1;
                while (p != 0) {
                    if (expression.charAt(j) == '}') p--;
                    else if (expression.charAt(j) == '{') p++;
                    j++;
                }
                List<String> l = braceExpansionII(expression.substring(i+1, j-1));
                if (preSign == '*') {
                    stack.add(merge(stack.pop(), l));
                } else {
                    stack.add(l);
                    preSign = '*';
                }
                i = j;
            } else if (Character.isAlphabetic(expression.charAt(i))) {
                List<String> l = new ArrayList<>();
                l.add(expression.charAt(i) + "");
                if (preSign == '*') {
                    stack.add(merge(stack.pop(), l));
                } else {
                    stack.add(l);
                    preSign = '*';
                }
                i++;
            } else if (expression.charAt(i) == ',') {
                preSign = '+';
                i++;
            }
        }
        List<String> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            for (String s : stack.pop()) {
                if (!result.contains(s)) result.add(s);
            }
        }
        Collections.sort(result);
        return result;
    }

    private List<String> merge(List<String> l1, List<String> l2) {
        List<String> result = new ArrayList<>();
        for (String s1 : l1) {
            for (String s2 : l2) {
                result.add(s1 + s2);
            }
        }
        return result;
    }
}
