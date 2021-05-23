package linkedlist;

public class MergeKSortedLists {

    public static void main(String[] args) {
        ListNode a = ListNode.createList(1, 4, 5);
        ListNode b = ListNode.createList(1, 3, 4);
        ListNode c = ListNode.createList(2, 6);
        MergeKSortedLists obj = new MergeKSortedLists();
        // System.out.println(obj.mergeKLists(new ListNode[] { a, b, c }));
        System.out.println("xyz");
        System.out.println(obj.split(new ListNode[] { a, b, c }, 0, 3));
    }

    public ListNode mergeLists(ListNode a, ListNode b) {

        ListNode bPrev = null;
        ListNode bHead = b;
        while (a != null && b != null) {
            if (a.val < b.val) {
                ListNode temp = a.next;
                if (bPrev != null) {
                    bPrev.next = a;
                } else {
                    bHead = a;
                }
                bPrev = a;
                a.next = b;
                a = temp;
            } else {
                bPrev = b;
                b = b.next;
            }
        }
        if (a != null) {
            if (bPrev != null) {
                bPrev.next = a;
            } else {
                bHead = a;
            }
        }
        return bHead;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = lists[0];
        for (int i = 1; i < lists.length; i++) {
            ans = mergeLists(ans, lists[i]);
        }
        return ans;
    }

    public ListNode split(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return null;
        }
        if (end - start == 1) {
            return lists[start];
        }
        int mid = (start + end) / 2;
        return mergeLists(split(lists, start, mid),
                split(lists, mid, end));
    }

}
