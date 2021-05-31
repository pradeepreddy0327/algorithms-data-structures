package linkedlist;

public class IntersectionOfLinkedLists {

	
	// leetcode problem 160
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int listASize = getSize(headA);
		int listBSize = getSize(headB);
		ListNode currentA = traverse(headA, listASize-listBSize);
		ListNode currentB = traverse(headB, listBSize-listASize);
		while(currentA != null && currentB != null){
			if(currentA == currentB) return currentA;
			currentA = currentA.next;
			currentB = currentB.next;
		}
		return null;
	}

	private ListNode traverse(ListNode node, int i){
		while(i>0){
			node = node.next;
			i--;
		}
		return node;
	}
	private int getSize(ListNode node){
		int size = 0;
		while(node != null){
			size++;
			node = node.next;
		}
		return size;
	}

}
