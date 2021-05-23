package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 80, 30, 90, 40, 50, 70 };
        QuickSort obj = new QuickSort();
        obj.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    private void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            sort(arr, low, pivot);
            sort(arr, pivot + 1, high);
        }
    }

    private int partition(int[] arr, int low, int high) {
        int pivot = arr[high - 1];
        int i = low;
        for (int j = low; j < high - 1; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, high - 1);
        return i;
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

}
