package reflection;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2));
        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

    private int c;
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.c = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        ListNode n = map.get(key);
        if (n == null) {
            return -1;
        }

        n.prev.next = n.next;
        n.next.prev = n.prev;
        addAtTop(n);
        return n.val;
    }

    public void put(int key, int value) {
        remove(key);
        ListNode n = new ListNode(key, value);
        map.put(key, n);
        addAtTop(n);
        removeIfNeeded();
    }

    private void addAtTop(ListNode n) {
        head.next.prev = n;
        n.next = head.next;
        head.next = n;
        n.prev = head;
    }

    private void removeIfNeeded() {
        if (map.size() > c) {
            remove(tail.prev.key);
        }
    }

    private void remove(int key) {
        if (map.get(key) != null) {
            ListNode n = map.get(key);
            map.remove(key);
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }

    private class ListNode {
        int val;
        int key;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
        }
    }
}
