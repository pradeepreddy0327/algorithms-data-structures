package own.ds;

import java.util.NoSuchElementException;

public class LinkedList<T> {
    private final ListNode<T> head;
    private final ListNode<T> tail;
    int count;
    public LinkedList(){
        head = new ListNode<>();
        tail = new ListNode<>();
        head.next = tail;
        tail.prev = head;
    }

    public void addFirst(T val){
        ListNode<T> node = new ListNode<>(val);
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        count++;
    }

    public void addLast(T val){
        ListNode<T> node = new ListNode<>(val);
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next= node;
        tail.prev = node;
        count++;
    }

    public T removeFirst(){
        if(!isEmpty()){
            ListNode<T> node = head.next;
            node.next.prev = head;
            head.next =  node.next;
            count--;
            return node.val;
        }
        throw new NoSuchElementException("LinkedList is empty");
    }

    public T peekFirst(){
        if(!isEmpty()){
            return head.next.val;
        }
        throw new NoSuchElementException("LinkedList is empty");
    }

    public T peekLast(){
        if(!isEmpty()){
            return tail.prev.val;
        }
        throw new NoSuchElementException("LinkedList is empty");
    }

    public T removeLast(){
        if(!isEmpty()){
            ListNode<T> node = tail.prev;
            node.prev.next = tail;
            tail.prev =  node.prev;
            count--;
            return node.val;
        }
        throw new NoSuchElementException("LinkedList is empty");
    }

    public boolean isEmpty(){
        return count == 0;
    }
    private static class ListNode<T>{
        public ListNode(T val) {
            this.val = val;
        }
        public ListNode() {
        }
        ListNode<T> prev;
        ListNode<T> next;
        T val;
    }
}




