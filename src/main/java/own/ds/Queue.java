package own.ds;

public class Queue<T> {
    private LinkedList<T> linkedList;

    public Queue(){
        linkedList = new LinkedList<>();
    }
    public void push(T val){
        linkedList.addFirst(val);
    }

    public T peek(){
        return linkedList.peekLast();
    }

    public T pop() {
        return linkedList.removeLast();
    }

    public boolean isEmpty(){
        return linkedList.isEmpty();
    }
}
