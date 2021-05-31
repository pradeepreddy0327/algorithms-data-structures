package dequeue;

import java.util.Deque;
import java.util.LinkedList;

public class MakeValidParentheses {

    // leetcode: 1249
    public String minRemoveToMakeValid(String s) {
        Deque<ParenthesesIndex> dq= new LinkedList<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '('){
                dq.addLast(new ParenthesesIndex(ParenthesesType.OPEN, i));
            } else if(s.charAt(i) == ')'){
                if(!dq.isEmpty() && dq.peekLast().parenthesesType.equals(ParenthesesType.OPEN)) dq.pollLast();
                else dq.addLast(new ParenthesesIndex(ParenthesesType.CLOSED, i));
            }
        }
        StringBuilder sb = new StringBuilder("");
        for(int i=0;i<s.length();i++){
            if(!dq.isEmpty() && dq.peekFirst().index == i){
                dq.pollFirst();
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    class ParenthesesIndex{
        ParenthesesType parenthesesType;
        Integer index;
        ParenthesesIndex(ParenthesesType type, Integer index){
            this.parenthesesType = type;
            this.index = index;
        }
    }
    enum ParenthesesType{
        OPEN, CLOSED
    }
}
