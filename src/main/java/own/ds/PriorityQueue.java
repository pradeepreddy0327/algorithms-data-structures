package own.ds;

public class PriorityQueue<T extends Comparable<T>> {
    private MinHeap<T> minHeap;

    public PriorityQueue(){
        minHeap = new MinHeap<>();
    }

    public T getMin(){
        return minHeap.getMin();
    }

    public T extractMin(){
        return minHeap.extractMin();
    }

    public void insert(T val){
        minHeap.insert(val);
    }

    public void delete(T val){
        minHeap.delete(val);
    }

    public boolean isEmpty(){
        return minHeap.isEmpty();
    }
}
