package leet.code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeNumberSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int[] arr = {-1, 0, 1, 2, -1, -4};
     System.out.println(new ThreeNumberSum().threeSum(arr));
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Map<Integer, Set<List<Integer>>> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				Set<List<Integer>> s = map.get(0 - nums[i] - nums[j]);
				if (s == null) {
					s = new HashSet<List<Integer>>();
					map.put(0 - nums[i] - nums[j], s);
				}
				List<Integer> t = new ArrayList<>();
				t.add(i);
				t.add(j);
				s.add(t);
			}
		}
		Set<List<Integer>> ans = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			Set<List<Integer>> s = map.get(nums[i]);
			if (s != null) {
				for (List<Integer> l : s) {
					if (!l.contains(i)) {
						List<Integer> triplet = new ArrayList<>();
						triplet.add(nums[l.get(0)]);
						triplet.add(nums[l.get(1)]);
						triplet.add(nums[i]);
						Collections.sort(triplet);
						ans.add(triplet);
					}
				}
			}
		}
		return new ArrayList<List<Integer>>(ans);
	}

}
