package hashtable;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static void main(String[] args) {
        SubArraySum obj = new SubArraySum();
        System.out.println(obj.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(obj.subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] += i > 0 ? nums[i - 1] : 0;
            if (nums[i] == k) ans++;
            ans += map.getOrDefault(nums[i] - k, 0);
            map.compute(nums[i], (key, v) -> v == null ? 1 : v + 1);
        }
        return ans;
    }

}
