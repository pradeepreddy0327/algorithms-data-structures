package own.ds;

public class MinHeapTest {

    public static void main(String[] args) {
        MinHeap<Integer> minHeap = new MinHeap<>();
        minHeap.insert(57);
        minHeap.insert(30);
        minHeap.insert(44);
        minHeap.insert(22);
        minHeap.insert(11);
        minHeap.insert(55);
        minHeap.insert(27);
        minHeap.insert(14);
        minHeap.insert(9);
        minHeap.insert(77);
        minHeap.delete(22);
        minHeap.delete(30);
        minHeap.insert(51);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.extractMin());
        }
        test2();
    }

    private static void test2(){
        MinHeap<Integer> minHeap = new MinHeap<>();
        for (int i=100;i>=0;i--){
            minHeap.insert(i);
        }
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.extractMin());
        }
    }

}
