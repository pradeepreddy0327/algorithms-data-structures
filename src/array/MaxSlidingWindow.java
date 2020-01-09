package array;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// lc 239
public class MaxSlidingWindow {

    public static void main(String[] args) {
        System.out.println("max2");
        MaxSlidingWindow obj = new MaxSlidingWindow();
        System.out.println(Arrays.toString(obj
                .maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
        System.out.println(Arrays.toString(obj
                .maxSlidingWindow2(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int j = 0;
        ans[j] = getMax(nums, j, k);
        for (int i = j + 1; i <= nums.length - k; i++) {
            int max = nums[i - 1] == ans[j] ? getMax(nums, i, k)
                    : Math.max(ans[j], nums[i + k - 1]);
            ans[i] = max;
            j++;
        }
        return ans;
    }

    private int getMax(int[] nums, int j, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = j; i < j + k; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            while (!dq.isEmpty() && current > nums[dq.getLast()]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (!dq.isEmpty() && dq.getFirst() <= i - k) {
                dq.pollFirst();
            }
            if (i >= k-1) {
                ans[i - k + 1] = nums[dq.getFirst()];
            }
        }
        return ans;
    }
}
