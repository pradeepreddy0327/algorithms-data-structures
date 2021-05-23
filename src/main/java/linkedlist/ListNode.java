package linkedlist;

public class ListNode {
	Integer val;
	ListNode next;

	ListNode(Integer value) {
		this.val = value;
	}

	@Override
    public String toString() {
		String x = this.val + "";
		ListNode temp = this.next;
		while (temp != null) {
			x = x + ", " + temp.val;
			temp = temp.next;
		}
		return x;
	}

    public static ListNode createList(int... arr) {
        ListNode head = null;
        ListNode prev = null;
        for (Integer i : arr) {
            ListNode n = new ListNode(i);
            if (head == null) {
                head = n;
            } else {
                prev.next = n;
            }
            prev = n;
        }
        return head;
    }
}
