package sort;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 80, 30, 90, 40, 50, 70 };
        MergeSort obj = new MergeSort();
        obj.mergeSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    public void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length);
    }

    private void mergeSort(int[] arr, int low, int high) {
        if (low < high - 1) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid, high);
            merge(arr, low, mid, high);
        }

    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] left = Arrays.copyOfRange(arr, low, mid);
        int[] right = Arrays.copyOfRange(arr, mid, high);
        int i = 0;
        int j = 0;
        int k = low;
        while (i < mid - low && j < high - mid) {
            if (left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < mid - low) {
            arr[k++] = left[i++];
        }
    }

}
