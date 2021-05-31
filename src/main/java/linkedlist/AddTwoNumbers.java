package linkedlist;

public class AddTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode head = new ListNode(0);
		ListNode prev = head;
		while(l1 != null || l2!=null){
			int sum = getVal(l1) + getVal(l2) + carry;
			carry = sum/10;
			sum = sum%10;
			ListNode node = new ListNode(sum);
			prev.next = node;
			prev = node;
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		if(carry != 0){
			prev.next = new ListNode(carry);
		}
		return head.next;
	}
	private int getVal(ListNode node){
		return node == null ? 0 : node.val;
	}
}
