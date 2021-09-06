package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LispExpression {

    public static void main(String[] args) {
        LispExpression obj = new LispExpression();
        System.out.println(obj.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))"));
        System.out.println(obj.evaluate("(let x 3 x 2 x)"));
        System.out.println(obj.evaluate("(let x 1 y 2 x (add x y) (add x y))"));
        System.out.println(obj.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))"));
        System.out.println(obj.evaluate("(let a1 3 b2 (add a1 1) b2)"));
    }

    public int evaluate(String expression) {
        return evalExp(expression, new HashMap<>());
    }

    private int evalExp(String expression, Map<String, Integer> valueMap) {
        if (expression.startsWith("(")) {
            return evalExp(expression.substring(1, expression.length() - 1), new HashMap<>(valueMap));
        }
        List<String> parsed = parse(expression);
        if (parsed.get(0).equals("let")) {
            int i = 1;
            while (i + 1 < parsed.size()) {
                valueMap.put(parsed.get(i), evalExp(parsed.get(i + 1), new HashMap<>(valueMap)));
                i = i + 2;
            }
            return evalExp(parsed.get(i), new HashMap<>(valueMap));
        } else if (parsed.get(0).equals("add")) {
            return evalExp(parsed.get(1), new HashMap<>(valueMap)) + evalExp(parsed.get(2), new HashMap<>(valueMap));
        } else if (parsed.get(0).equals("mult")) {
            return evalExp(parsed.get(1), new HashMap<>(valueMap)) * evalExp(parsed.get(2), new HashMap<>(valueMap));
        } else if (valueMap.containsKey(parsed.get(0))) {
            return valueMap.get(parsed.get(0));
        } else {
            return Integer.parseInt(parsed.get(0));
        }
    }

    private List<String> parse(String expression) {
        List<String> list = new ArrayList<>();
        Map<Integer, Integer> indexMap = getIndexMap(expression);
        int i = 0;
        int j = 0;
        while (i < expression.length()) {
            if (expression.charAt(i) == ' ') {
                if (i != j) list.add(expression.substring(j, i));
                i++;
                j = i;
            } else if (expression.charAt(i) == '(') {
                i = indexMap.get(i) + 1;
                list.add(expression.substring(j, i));
                j = i;
            } else i++;
        }
        if (i != j) list.add(expression.substring(j, i));
        return list;
    }

    private Map<Integer, Integer> getIndexMap(String expression) {
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(')
                stack.add(i);
            else if (expression.charAt(i) == ')') {
                indexMap.put(stack.pop(), i);
            }
        }
        return indexMap;
    }
}
