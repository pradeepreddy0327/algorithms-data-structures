package linkedlist;

public class MyLinkedList {

	public static void main(String[] args) {
		MyLinkedList obj = new MyLinkedList();
		obj.addAtHead(8);
		obj.get(1);
		obj.addAtTail(81);
		obj.deleteAtIndex(2);
		obj.addAtHead(26);
		obj.deleteAtIndex(2);
		obj.get(1);
		obj.addAtTail(24);
		obj.addAtHead(15);
		obj.addAtTail(0);
		obj.addAtTail(13);
		obj.addAtTail(1);
		obj.addAtIndex(6,33);
		obj.get(6);
		obj.addAtIndex(2,91);
		obj.addAtHead(82);
		obj.deleteAtIndex(6);
		obj.addAtIndex(4,11);
		obj.addAtHead(3);
		obj.addAtIndex(7,14);
		obj.deleteAtIndex(1);
		obj.get(6);
		obj.addAtTail(99);
		obj.deleteAtIndex(11);
		obj.deleteAtIndex(7);
		obj.addAtTail(5);
		obj.addAtTail(92);
		obj.addAtIndex(7,92);
		obj.addAtHead(57);
		obj.get(2);
		obj.get(6);
		obj.addAtTail(39);
		obj.addAtTail(51);
		obj.addAtTail(3);
		obj.addAtTail(22);
		obj.addAtIndex(5,26);
		obj.addAtIndex(9,52);
		obj.addAtHead(69);
		obj.addAtIndex(5,58);
		obj.addAtTail(79);
		obj.addAtHead(7);
		obj.addAtHead(41);
		obj.addAtHead(33);
		obj.addAtHead(88);
		obj.addAtHead(44);
		obj.addAtHead(8);
		obj.addAtTail(72);
		obj.addAtHead(93);
		obj.deleteAtIndex(18);
		obj.addAtHead(1);
		obj.get(9);
		obj.addAtHead(46);
		obj.get(9);
		obj.addAtHead(92);
		obj.addAtHead(71);
		obj.addAtHead(69);
		obj.addAtIndex(11,54);
		obj.deleteAtIndex(27);
		obj.addAtTail(83);
		obj.deleteAtIndex(12);
		obj.get(20);
		obj.addAtIndex(19,97);
		obj.addAtHead(77);
		obj.addAtTail(36);
		obj.deleteAtIndex(3);
		obj.addAtHead(35);
		obj.addAtIndex(16,68);
		obj.deleteAtIndex(22);
		obj.deleteAtIndex(36);
		obj.deleteAtIndex(17);
		obj.addAtHead(62);
		obj.addAtTail(89);
		obj.addAtTail(61);
		obj.addAtHead(6);
		obj.addAtTail(92);
		obj.addAtIndex(28,69);
		obj.deleteAtIndex(23);
		obj.deleteAtIndex(28);
		obj.addAtIndex(7,4);
		obj.addAtHead(0);
		obj.addAtHead(24);
		obj.addAtTail(52);
		obj.get(1);
		obj.addAtIndex(23,3);
		obj.get(7);
		obj.addAtHead(6);
		obj.addAtHead(68);
		obj.addAtHead(79);
		obj.addAtIndex(45,90);
		obj.addAtIndex(41,52);
		obj.get(28);
		obj.addAtHead(25);
		obj.get(9);
		obj.get(32);
		obj.addAtTail(11);
		obj.addAtHead(90);
		obj.addAtHead(24);
		obj.addAtTail(98);
		obj.addAtTail(36);
		obj.get(34);
		obj.addAtTail(26);

	}

	int size;
	ListNode head;

	public MyLinkedList() {
		head = new ListNode(-1);
		size = 0;
	}

	/**
	 * Get the value of the index-th node in the linked list. If the index is
	 * invalid, return -1.
	 */
	public int get(int index) {
		System.out.println(index);
		if (index >= size) {
			return -1;
		}
		int i = -1;
		ListNode current = head;
		while (i++ < index) {
			current = current.next;
		}
		return current.val;
	}

	/**
	 * Add a node of value val before the first element of the linked list. After
	 * the insertion, the new node will be the first node of the linked list.
	 */
	public void addAtHead(int val) {
		ListNode n = new ListNode(val);
		n.next = head.next;
		head.next = n;
		size++;
	}

	/** Append a node of value val to the last element of the linked list. */
	public void addAtTail(int val) {
		ListNode current = head;
		while (current.next != null) {
			current = current.next;
		}
		current.next = new ListNode(val);
		size++;
	}

	/**
	 * Add a node of value val before the index-th node in the linked list. If index
	 * equals to the length of linked list, the node will be appended to the end of
	 * linked list. If index is greater than the length, the node will not be
	 * inserted.
	 */
	public void addAtIndex(int index, int val) {
		if (index > size)
			return;

		ListNode newNode = new ListNode(val);
		int i = -1;
		ListNode current = head;
		while (i++ < index - 1) {
			current = current.next;
		}
		newNode.next = current.next;
		current.next = newNode;
		size++;

	}

	/** Delete the index-th node in the linked list, if the index is valid. */
	public void deleteAtIndex(int index) {
		if (index >= size)
			return;
		int i = -1;
		ListNode current = head;
		while (i++ < index - 1) {
			current = current.next;
		}
		current.next = current.next != null ? current.next.next : null;
		size--;

	}

}
