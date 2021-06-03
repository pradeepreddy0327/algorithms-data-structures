package array;

import java.util.HashMap;
import java.util.Map;

// leetcode 523  tags: Facebook
public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        map.put(nums[0]%k, 0);
        map.put(0,-1);
        for(int i=1;i<nums.length;i++){
            nums[i]+= nums[i-1];
            if(!map.containsKey(nums[i]%k)) map.put(nums[i]%k, i);
            else if(i-map.get(nums[i]%k)>1) return true;
        }
        return false;
    }
}
