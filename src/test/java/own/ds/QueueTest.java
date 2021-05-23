package own.ds;

public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue();
        queue.push(57);
        queue.push(30);
        queue.push(44);
        queue.push(22);
        queue.push(11);
        queue.push(55);
        queue.push(27);
        queue.push(14);
        queue.push(9);
        queue.push(77);
        queue.push(51);
        while (!queue.isEmpty()) {
            System.out.println(queue.pop());
        }
    }
}
