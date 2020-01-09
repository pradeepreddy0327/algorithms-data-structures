package backtracking;

import java.util.Arrays;

public class Jump {

    public static void main(String[] args) {
        Jump obj = new Jump();
        int[] q = new int[] { 5, 8, 1, 8, 9, 8, 7, 1, 7, 5, 8,
                6, 5, 4, 7, 3, 9, 9, 0, 6, 6, 3, 4, 8, 0, 5, 8, 9, 5, 3, 7, 2,
                1, 8, 2, 3, 8, 9, 4, 7, 6, 2, 5, 2, 8, 2, 7, 9, 3, 7, 6, 9, 2,
                0, 8, 2, 7, 8, 4, 4, 1, 1, 6, 4, 1, 0, 7, 2, 0, 3, 9, 8, 7, 7,
                0, 6, 9, 9, 7, 3, 6, 3, 4, 8, 6, 4, 3, 3, 2, 7, 8, 5, 8, 6,
                0 };
        System.out.println(q.length);
        // System.out.println(obj.jump(q));
        System.out.println(obj.jumpDp(q));
    }

    int ans = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        for (int i = nums[0]; i > 0; i--) {
            backTrack(nums, i, 1);
        }
        return ans;
    }

    private void backTrack(int[] nums, int i, int j) {
        System.out.println(i + " " + j);
        if (j >= ans) {
            return;
        }
        if (i >= nums.length - 1) {
            ans = Math.min(ans, j);
            return;
        }
        for (int k = nums[i]; k > 0; k--) {
            if (j + 1 >= ans) {
                return;
            }
            backTrack(nums, i + k, j + 1);
        }
    }

    public int jumpDp(int[] nums) {
        int[] ansArr = new int[nums.length];
        for (int i = nums.length - 2; i >= 0; i--) {
            ansArr[i] = jumpFromIndex(ansArr, nums, i);
        }
        System.out.println(Arrays.toString(ansArr));
        return ansArr[0];
    }

    private int jumpFromIndex(int[] ansArr, int[] nums, int i) {
        if (i >= nums.length - 1) {
            return 0;
        }
        if (ansArr[i] != 0) {
            return ansArr[i];
        }
        int min = Integer.MAX_VALUE;
        for (int j = nums[i]; j > 0; j--) {
            min = Math.min(min, 1 + jumpFromIndex(ansArr, nums, i + j));
        }
        ansArr[i] = min == Integer.MAX_VALUE ? Integer.MAX_VALUE - 1 : min;
        return ansArr[i];
    }
}
