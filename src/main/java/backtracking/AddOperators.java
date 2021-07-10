package backtracking;


import java.util.ArrayList;
import java.util.List;

public class AddOperators {
    public static void main(String[] args) {
        AddOperators obj = new AddOperators();
//        System.out.println(obj.addOperators("232", 8));
//        System.out.println(obj.addOperators("105", 5));
        System.out.println(Integer.MIN_VALUE);
        System.out.println(obj.addOperators("2147483648", Integer.MIN_VALUE));

    }
    public List<String> addOperators(String num, int target) {
        List<String> ans = new ArrayList<>();
        recurse(num, target, ans, 1, num.charAt(0)+"");
        return ans;
    }

    private void recurse(String num,  int target, List<String> ans, int i, String s){
        if(i==num.length()){
            if(evaluate(s) == target){
                ans.add(s);
            }
            return;
        }
        char c = num.charAt(i);
        recurse(num, target, ans, i+1, s + "+" + c);
        recurse(num, target, ans, i+1, s + "-" + c);
        recurse(num, target, ans, i+1, s + "*" + c);
        recurse(num, target, ans, i+1, s + c);
    }
    public long evaluate(String s){
        long current = 0;
        String currentString =  "";
        Node head = new Node(0);
        Node prev = new Node('+');
        head.next = prev;
        for(char c:s.toCharArray()){
            if(c == '+' || c == '-' || c == '*'){
                if(currentString.length()>1 && currentString.charAt(0) == '0') return Long.MAX_VALUE;
                Node n1 = new Node(current);
                Node n2 = new Node(c);
                prev.next= n1;
                n1.prev = prev;
                n1.next = n2;
                n2.prev= n1;
                prev = n2;
                current = 0;
                currentString = "";
            } else {
                currentString = currentString + c;
                current = current * 10 + (c - '0');
            }
        }
        if(currentString.length()>1 && currentString.charAt(0) == '0') return Long.MAX_VALUE;
        Node n1 = new Node(current);
        prev.next = n1;
        n1.prev = prev;
        applyMultiplication(head);
        return applyOperators(head);
    }

    private void applyMultiplication(Node head){
        Node current = head;
        while(current != null){
            if(current.operator != null && current.operator.equals(Operator.MULTIPLY)){
                current.prev.val *= current.next.val;
                Node next = current.next.next;
                current.prev.next = next;
                if(next != null) next.prev = current.prev;
                current = next;
            } else{
                current = current.next;
            }
        }
    }

    private long applyOperators(Node head){
        long val = 0;
        Operator op = Operator.ADD;
        Node current = head;
        while(current != null){
            if(current.operator != null){
                if(current.operator.equals(Operator.ADD))
                    val += current.next.val;
                else
                    val -= current.next.val;
            }
                current = current.next;
        }
        return val;
    }


    class Node{
        Operator operator;
        Long  val;
        Node prev;
        Node next;
        Node(long val){
            this.val = val;
        }
        Node(char c){
            if(c == '+'){
                operator = Operator.ADD;
            } else if(c == '*'){
                operator = Operator.MULTIPLY;
            } else {
                operator = Operator.SUBTRACT;
            }
        }
    }
    enum Operator{
        ADD, MULTIPLY, SUBTRACT;
    }
}
