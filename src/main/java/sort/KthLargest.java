package sort;

import java.util.Random;

public class KthLargest {
    public static void main(String[] args) {
        KthLargest obj = new KthLargest();
        System.out.println(obj.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        System.out.println(obj.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        quickSelect(nums, 0, nums.length - 1, nums.length - k);
        return nums[nums.length - k];
    }
    Random rand = new Random(0);
    private void quickSelect(int[] nums, int start, int end, int k) {
        if (start >= end) return;
        int pivotIndex = rand.nextInt(end - start) + start;
        swap(nums, pivotIndex, end);
        int pivot = nums[end];
        int i = start;
        int j = end - 1;
        while (i <= j) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            } else {
                j--;
            }
        }
        swap(nums, i, end);
        if (i == k) return;
        else if (i < k) quickSelect(nums, i + 1, end, k);
        else quickSelect(nums, start, i - 1, k);

    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
