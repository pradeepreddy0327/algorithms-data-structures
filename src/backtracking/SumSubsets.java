package backtracking;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

public class SumSubsets {

	// code fights : back tracking:
	// https://app.codesignal.com/interview-practice/task/uJvihuafm7PRDPCsL
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5 };
		SumSubsets obj = new SumSubsets();
		PrintUtil.printList(obj.sumSubsets(a, 5));

	}

	public List<List<Integer>> sumSubsets(int[] a, int s) {
		List<List<Integer>> ans = new ArrayList<>();
		backTrack(a, s, new ArrayList<Integer>(), ans, 0);
		return ans;
	}

	private void backTrack(int[] a, int s, List<Integer> l, List<List<Integer>> ans, int j) {
		if (s == 0) {
			ans.add(l);
		}
		for (int i = j; i < a.length; i++) {
			if (s - a[i] < 0) {
				return;
			}
			l.add(a[i]);
			backTrack(a, s - a[i], new ArrayList<Integer>(l), ans, i + 1);
			l.remove(l.size() - 1);
		}

	}

}
