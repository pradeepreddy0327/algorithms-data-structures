package priority.queue;

import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    public MedianFinder() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<Integer>((a, b) -> (b - a));
    }

    public void addNum(int num) {
        minH.add(num);
        maxH.add(minH.poll());
        if (maxH.size() > minH.size()) {
            minH.add(maxH.poll());
        }
    }

    public double findMedian() {
        if (maxH.size() != minH.size()) {
            return (double) minH.peek();
        }
        return ((double) (minH.peek() + maxH.peek())) / 2;
    }

}
