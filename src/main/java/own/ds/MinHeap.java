package own.ds;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MinHeap {

    private Integer[] arr;
    private int count;

    public MinHeap(){
        arr = new Integer[32];
    }

    private void increaseArraySize(){
        arr = Arrays.copyOf(arr, arr.length*2);
    }

    public Integer getMin(){
        if(!isEmpty()) {
            return arr[0];
        }
        throw new NoSuchElementException("MinHeap is empty");
    }

    public Integer extractMin(){
        if(!isEmpty()) {
            int min = arr[0];
            count--;
            arr[0] = arr[count];
            arr[count] = 0;
            heapify(0);
            return min;
        }
        throw new NoSuchElementException("MinHeap is empty");
    }

    private void heapify(int i) {
        int leftChildIndex = 2*i+1;
        int rightChildIndex = leftChildIndex+1;
        if(leftChildIndex>=count){
            return;
        } else if(rightChildIndex>= count && arr[i]>arr[leftChildIndex]){
            swap(i,leftChildIndex);
            heapify(leftChildIndex);
        } else {
            int minValueIndex = arr[leftChildIndex]<arr[rightChildIndex]?leftChildIndex:rightChildIndex;
            if(arr[i]>arr[minValueIndex]) {
                swap(i, minValueIndex);
                heapify(minValueIndex);
            }
        }
    }

    private void swap(int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }


    public void insert(Integer val){
        if(count == arr.length){
            increaseArraySize();
        }
        arr[count++] = val;
        int i = count -1;
        while(arr[(i-1)/2]>arr[i]){
            swap(i, (i-1)/2);
            i = (i-1)/2;
        }
    }

    public boolean isEmpty(){
        return count == 0;
    }
}
