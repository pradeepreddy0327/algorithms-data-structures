package reflection;

import java.util.HashMap;
import java.util.Map;


public class LFUCache {

    public static void main(String[] args) {
        LFUCache cache = new LFUCache(2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // returns 1
        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3.
        cache.put(4, 4); // evicts key 1.
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }

    private int c;
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> map;

    public LFUCache(int capacity) {
        this.c = capacity;
        this.head = new ListNode(-1, -1, Integer.MAX_VALUE);
        this.tail = new ListNode(-1, -1, Integer.MAX_VALUE);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }

    public int get(int key) {
        ListNode n = map.get(key);
        if (n == null) {
            return -1;
        }
        n.freq = n.freq+1;
        move(n);
        return n.val;
    }

    private void move(ListNode n) {
        ListNode prev = n.prev;
        n.prev.next = n.next;
        n.next.prev = n.prev;
        while(prev.freq<=n.freq) {
            prev = prev.prev;
        }
        addAfter(n, prev);
    }

    private void addAfter(ListNode n, ListNode p) {
        p.next.prev = n;
        n.next = p.next;
        p.next = n;
        n.prev = p;
    }

    public void put(int key, int value) {
        int f = 0;
        if (map.get(key) != null) {
            f = map.get(key).freq + 1;
            remove(key);
        }
        if (map.size() == c) {
            remove(tail.prev.key);
        }
        ListNode n = new ListNode(key, value, f + 1);
        map.put(key, n);
        ListNode prev = tail.prev;
        while (prev.freq <= n.freq) {
            prev = prev.prev;
        }
        addAfter(n, prev);
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
        int freq;
        ListNode prev;
        ListNode next;

        ListNode(int key, int val) {
            this.val = val;
            this.key = key;
            this.freq = 1;
        }

        ListNode(int key, int val, int freq) {
            this.val = val;
            this.key = key;
            this.freq = freq;
        }
    }
}
