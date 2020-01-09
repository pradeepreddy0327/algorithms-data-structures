package leet.code.linkedlist;

import java.util.HashMap;
import java.util.Map;

//lc 138
public class CopyRandomList {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    Map<Node, Node> map = new HashMap<>();

    public Node copyRandomList(Node n) {
        if(n==null) {
            return null;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }
        Node clone = new Node();
        clone.val = n.val;
        map.put(n,clone);
        clone.random = copyRandomList(n.random);
        clone.next = copyRandomList(n.next);
        return clone;
    }

    class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int _val, Node _next, Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }
    };

}
