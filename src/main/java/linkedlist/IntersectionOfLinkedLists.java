package linkedlist;

public class IntersectionOfLinkedLists {

	
	// leetcode problem 160
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        ListNode a = headA;
	        ListNode b = headB;
	        int i=0, j =0;
	        while(a!=null){
	            i++;
	            a = a.next;
	        }
	        while(b!=null){
	            j++;
	            b = b.next;
	        }
	        a= headA;b=headB;
	        if(i>j){
	            int diff = i-j;
	            while(diff>0){
	                a=a.next;
	                diff--;
	            }
	        } else if(i<j){
	           int diff = j-i;
	            while(diff>0){
	                b=b.next;
	                diff--;
	            } 
	        }
	        while(a != null && b != null){
	            if(a.equals(b)) return a;
	            a = a.next;
	            b = b.next;
	        }
	        
	        return null;
	     }

}
