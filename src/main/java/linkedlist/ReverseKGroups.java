package linkedlist;

public class ReverseKGroups {

	public static void main(String[] args) {
        ListNode a = ListNode.createList(1, 2, 3, 4, 5);
        System.out.println(a);
        // ListNode b = new ListNode(2);
        // ListNode c = new ListNode(3);
        // ListNode d = new ListNode(4);
        // ListNode e = new ListNode(5);
        // a.next = b;
        // b.next = c;
        // c.next = d;
        // d.next = e;
        // ListNode.createList(1, 2, 3, 4, 5);
		System.out.println(new ReverseKGroups().reverseKGroup(a, 3));

	}

	public ListNode reverseKGroup(ListNode head, int k) {

		int i = 0;
		Group h = null;
		Group c = null;
		Group p = null;
		while (head != null) {
			ListNode t = head.next;
			i++;
			if (i == 1 || (i - 1) % k == 0) {
				c = new Group();
				c.start = head;
				c.l = head;
				if (i == 1) {
                    h = c;
                }
			} else if (i % k == 0) {
				head.next = null;
				c.end = head;
				c.l = reverse(c.start);
				if (i == k) {
					p = c;
				} else {
					p.start.next = c.l;
					p = c;
				}
			}
			head = t;
		}
		if (p != null && i % k != 0) {
			p.start.next = c.l;
		}
		return h.l;
	}

	ListNode reverse(ListNode l) {
		ListNode prev = null;
		while (l != null) {
			ListNode temp = l.next;
			l.next = prev;
			prev = l;
			l = temp;
		}
		return prev;
	}

}

class Group {
	ListNode start;
	ListNode l;
	ListNode end;
}
