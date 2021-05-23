package own.ds;

public class Stack<T> {
    private LinkedList<T> linkedList;

    public Stack(){
        linkedList = new LinkedList<>();
    }
    public void push(T val){
        linkedList.addFirst(val);
    }

    public T peek(){
        return linkedList.peekFirst();
    }

    public T pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
}
