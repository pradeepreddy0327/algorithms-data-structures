package linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode ans = null;
		ListNode prev = null;
		while (l1 != null || l2 != null) {
			int i = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
			carry = i / 10;
			i = i % 10;
			ListNode node = new ListNode(i);
			if (ans == null) {
				ans = node;
			} else {
				prev.next = node;
			}
			prev = node;
			if (l1 != null)
				l1 = l1.next;
			if (l2 != null)
				l2 = l2.next;
		}
		if (carry > 0)
			prev.next = new ListNode(carry);
		return ans;
	}
}
