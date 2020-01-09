package util;

public class Test3 {

	public static void main(String[] args) {
		ListNode<Integer> a = new ListNode(1);
		ListNode<Integer> b = new ListNode(2);
		ListNode<Integer> c = new ListNode(3);
		ListNode<Integer> d = new ListNode(4);
		ListNode<Integer> e = new ListNode(5);
		a.next = b;
		b.next = c;
		c.next = d;
		d.next = e;
		System.out.println(reverse(a));
		
		System.out.println(true || false && true); // above null and int or eoc
		System.out.println(true || false && false); // above null 3-8
		System.out.println(false || true && true);  // above not null int or eoc
		System.out.println(false || true && false); // above not null 3-8
		// sort(a);

	}

	private static ListNode<Integer> reverse(ListNode<Integer> n) {
		ListNode<Integer> prev = null;
		while (n != null) {
			ListNode<Integer> t = n.next;
			n.next = prev;
			prev = n;
			n = t;
		}
		return prev;
	}

	private static void sort(ListNode<Integer> d) {
		int countOfZeroes = 0;
		ListNode<Integer> copy = d;
		while (copy != null) {
			if (copy.val == 0)
				countOfZeroes++;
			copy = copy.next;
		}
		ListNode<Integer> copy2 = d;
		while (copy2 != null) {
			if (countOfZeroes > 0) {
				copy2.val = 0;
				countOfZeroes--;
			} else {
				copy2.val = 1;
			}
			copy2 = copy2.next;
		}
		System.out.println(d);
	}

}

class ListNode<T> {
	T val;
	ListNode<T> next;
	ListNode<T> prev;

	ListNode(T value) {
		this.val = value;
	}

	public String toString() {
		String x = this.val + "";
		ListNode<T> temp = this.next;
		while (temp != null) {
			x = x + ", " + temp.val;
			temp = temp.next;
		}
		return x;
	}
}
