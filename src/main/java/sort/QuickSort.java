package sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[]{10, 80, 30, 90, 40, 50, 70};
        QuickSort obj = new QuickSort();
        obj.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot = arr[end];
            int i = start;
            int j = end - 1;
            while (i <= j) {
                if (arr[j] < pivot) {
                    swap(arr, i, j);
                    i++;
                } else {
                    j--;
                }
            }
            swap(arr, i, end);
            sort(arr, start, i - 1);
            sort(arr, i + 1, end);
        }
    }


    private void swap(int[] arr, int i, int j) {
        int t = arr[j];
        arr[j] = arr[i];
        arr[i] = t;
    }

}
