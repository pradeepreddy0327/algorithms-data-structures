package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.PrintUtil;

public class CombinationSum {

	public static void main(String[] args) {
		int[] a = { 2, 3, 5, 9 };
		CombinationSum obj = new CombinationSum();
		PrintUtil.printList(obj.combinationSum(a, 9));

	}

	public List<List<Integer>> combinationSum(int[] a, int s) {
		Arrays.sort(a);
		List<List<Integer>> ans = new ArrayList<>();
		backTrack(a, s, new ArrayList<Integer>(), ans, 0);
		return ans;
	}

	private void backTrack(int[] a, int s, ArrayList<Integer> l, List<List<Integer>> ans, int j) {
		if (s == 0) {
			ans.add(l);
			return;
		}
		for (int i = j; i < a.length; i++) {
			if (s - a[i] < 0)
				return;
			l.add(a[i]);
			backTrack(a, s - a[i], new ArrayList<Integer>(l), ans, i);
			l.remove(l.size() - 1);
		}
	}

}
