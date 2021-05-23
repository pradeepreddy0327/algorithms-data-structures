package own.ds;

public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(57);
        stack.push(30);
        stack.push(44);
        stack.push(22);
        stack.push(11);
        stack.push(55);
        stack.push(27);
        stack.push(14);
        stack.push(9);
        stack.push(77);
        stack.push(51);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
