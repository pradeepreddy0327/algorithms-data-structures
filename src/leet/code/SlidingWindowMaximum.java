package leet.code;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum obj = new SlidingWindowMaximum();
        System.out.println(Arrays.toString(obj
                .maxSlidingWindow(new int[] { 1, 3, -1, -3, 5, 3, 6, 7 }, 3)));

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        Deque<Integer> dq = new LinkedList<Integer>();
        for (int i = 0; i < k - 1; i++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
        }
        int j = 0;
        for (int i = k - 1; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            ans[j++] = nums[dq.peekFirst()];
        }

        return ans;
    }

}
