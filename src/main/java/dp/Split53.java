package dp;

import java.util.List;

public class Split53 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    public static boolean split53(List<Integer> inputNums) {
        // All the values that are multiple of 5 must be in one group.
        // All the values that are a multiple of 3 (and not a multiple of 5)
        // must be in the other group.
        int[] nums = inputNums.stream().mapToInt(i -> i).toArray();
        return recursive(0, nums, 0, 0);
    }

    public static boolean recursive(int i, int[] nums, int sum1, int sum2) {
        if (i >= nums.length) {
            return sum1 == sum2;
        }
        if (nums[i] % 5 == 0) {
            return recursive(i + 1, nums, sum1 + nums[i], sum2);
        } else if (nums[i] % 3 == 0) {
            return recursive(i + 1, nums, sum1, sum2 + nums[i]);
        }
        return recursive(i + 1, nums, sum1 + nums[i], sum2)
                || recursive(i + 1, nums, sum1, sum2 + nums[i]);
    }

}
