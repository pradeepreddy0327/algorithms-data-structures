package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache2 {

	public static void main(String[] args) {
		//["LRUCache","put","put","get","put","put","get"]
		//[[2],[2,1],[2,2],[2],[1,1],[4,1],[2]]
		LRUCache l = new LRUCache(2);
		l.put(2,1);
		l.put(2, 2);
		System.out.println(l.get(2));
		l.put(1, 1);
		l.put(4, 1);
		System.out.println(l.get(2));

	}
}

class LRUCache {

	ListNode2 head;
	Map<Integer, ListNode2> map;
	ListNode2 last;
	int n;
	int i = 0;

	public LRUCache(int capacity) {
		head = new ListNode2(-1, -1);
		last = head;
		map = new HashMap<>();
		n = capacity;
	}

	public int get(int key) {
		ListNode2 l = map.get(key);
		if (l == null)
			return -1;
		if (l != last) {
			l.prev.next = l.next;
			if (l.next != null)
				l.next.prev = l.prev;
			i--;
			map.remove(l.key);
			put(key, l.val);
		}
		return l.val;
	}

	public void put(int key, int value) {
		remove(map.get(key));
		ListNode2 l = new ListNode2(key, value);
		last.next = l;
		l.prev = last;
		last = l;
		i++;
		if (i > n) {
			remove(head.next);
		}
		map.put(key, l);
	}

	public void remove(ListNode2 r) {
		if (r != null) {
			r.prev.next = r.next;
			if(r.next != null)r.next.prev = r.prev;
			map.remove(r.key);
			i--;
			if(r == last) {
				last = r.prev;
			}
		}
	}
}

class ListNode2 {
	int val;
	int key;
	ListNode2 next;
	ListNode2 prev;

	ListNode2(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
