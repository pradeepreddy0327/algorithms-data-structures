package math;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        BasicCalculator obj = new BasicCalculator();
        System.out.println(obj.calculate("3+2*2"));
        System.out.println(obj.calculate("2*3+4"));
        System.out.println(obj.calculateV2("2*3"));
        System.out.println(obj.calculateV2("3+2*2"));
        System.out.println(obj.calculateV2("2*3+4"));
        System.out.println(obj.calculateV2("2*3"));
    }

    public int calculate(String s) {
        int valueSoFar = 0;
        int i = 0;
        int lastValue = 0;
        int currentValue = 0;
        char operation = '+';
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                currentValue = currentValue * 10 + (c - '0');
                if (i != s.length()) continue;
            }
            if (operation == '+' || operation == '-') {
                if (operation == '-') currentValue = -currentValue;
                valueSoFar += lastValue;
                lastValue = currentValue;
            } else if (operation == '*')
                lastValue *= currentValue;
            else if (operation == '/')
                lastValue /= currentValue;
            currentValue = 0;
            operation = c;
        }
        valueSoFar += lastValue;
        return valueSoFar;
    }

    public int calculateV2(String s) {
        int i = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        int currentValue = 0;
        char operation = '+';
        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                currentValue = currentValue * 10 + (c - '0');
                if (i != s.length()) continue;
            }
            if (operation == '+' || operation == '-') {
                if (operation == '-') currentValue = -currentValue;
                if (stack.size() == 2) {
                    stack.add(stack.pop()+stack.pop());
                }
                stack.add(currentValue);
            } else if (operation == '*')
                stack.add(stack.pop()*currentValue);
            else if (operation == '/')
                stack.add(stack.pop()/currentValue);
            currentValue = 0;
            operation = c;
        }
        if (stack.size() == 2) {
            stack.add(stack.pop()+stack.pop());
        }
        return stack.pop();
    }
}
