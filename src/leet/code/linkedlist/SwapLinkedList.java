package leet.code.linkedlist;

public class SwapLinkedList {

	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		ListNode b = new ListNode(2);
		ListNode c = new ListNode(3);
		ListNode d = new ListNode(4);
		ListNode e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		System.out.println(a);
		System.out.println(new SwapLinkedList().swapPairs(a));

	}
	
	public ListNode swapPairs(ListNode head) {
        if(head  == null) return null;
        if(head.next == null) return head;
        ListNode a = head.next;;
        ListNode p = null;
        while(head != null){
            if(head.next != null){
                ListNode t = head.next.next;
                head.next.next = head;
                if(p != null){
                    p.next = head.next;
                } 
                p = head;
                head = t; 
            } else if(p != null){
                p.next = head;
                head = head.next;
            }
        }
        
        return a;
    }

}
