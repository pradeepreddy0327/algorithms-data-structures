package hashtable;

import java.util.HashMap;
import java.util.Map;

// leetcode 560  tags: Facebook
public class SubArraySum {
    public static void main(String[] args) {
        SubArraySum obj = new SubArraySum();
        System.out.println(obj.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(obj.subarraySum(new int[]{1, 2, 3}, 3));
    }

    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == k) ans++;
            ans += map.getOrDefault(sum - k, 0);
            map.compute(sum, (key, v) -> v == null ? 1 : v + 1);
        }
        return ans;
    }

}
