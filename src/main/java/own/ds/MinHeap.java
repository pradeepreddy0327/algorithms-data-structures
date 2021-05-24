package own.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class MinHeap<T extends Comparable<T>> {

    private T[] arr;
    private int count;
    // doesnt work for duplicates
    private Map<T,Integer> indexMap;

    public MinHeap() {
        arr = (T[]) new Comparable[32];
        indexMap = new HashMap<>();
    }

    private void increaseArraySize() {
        arr = Arrays.copyOf(arr, arr.length * 2);
    }

    public T getMin() {
        if (!isEmpty()) {
            return arr[0];
        }
        throw new NoSuchElementException("MinHeap is empty");
    }

    public T extractMin() {
        if (!isEmpty()) {
            T min = arr[0];
            count--;
            arr[0] = arr[count];
            indexMap.put(arr[count], 0);
            arr[count] = null;
            indexMap.remove(min);
            heapify(0);
            return min;
        }
        throw new NoSuchElementException("MinHeap is empty");
    }

    private void heapify(int i) {
        int leftChildIndex = 2 * i + 1;
        int rightChildIndex = leftChildIndex + 1;
        if (leftChildIndex >= count) {
            return;
        } else if (rightChildIndex >= count ) {
            if(arr[i].compareTo(arr[leftChildIndex]) > 0) {
                swap(i, leftChildIndex);
                heapify(leftChildIndex);
            }
        } else {
            int minValueIndex = arr[leftChildIndex].compareTo(arr[rightChildIndex]) < 0 ? leftChildIndex : rightChildIndex;
            if (arr[i].compareTo(arr[minValueIndex]) > 0) {
                swap(i, minValueIndex);
                heapify(minValueIndex);
            }
        }
    }

    private void swap(int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        indexMap.put(arr[i],i);
        indexMap.put(arr[j],j);
    }


    public void insert(T val) {
        if (count == arr.length) {
            increaseArraySize();
        }
        indexMap.put(val, count);
        arr[count++] = val;
        int i = count - 1;
        while (arr[(i - 1) / 2].compareTo(arr[i]) > 0) {
            swap(i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    public void delete(T val){
        Integer i = indexMap.remove(val);
        arr[i] = arr[count-1];
        indexMap.put(arr[i],i);
        arr[count-1]=null;
        count--;
        heapify(i);
    }

    public boolean isEmpty() {
        return count == 0;
    }
}
