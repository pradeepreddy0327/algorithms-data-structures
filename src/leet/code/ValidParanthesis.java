package leet.code;

import java.util.Stack;

public class ValidParanthesis {
  // leetcode problem 20
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(Character c:s.toCharArray()){
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            } else{
                if(stack.isEmpty()) return false;
                char p = stack.pop();
                if(!(( p == '{' && c == '}' ) || ( p == '[' && c == ']' )
                   || ( p == '(' && c == ')' ))){
                    return false;
                } 
            }
        }
        return stack.isEmpty();
    }

}
