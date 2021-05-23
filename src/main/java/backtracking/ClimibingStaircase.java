package backtracking;

import java.util.ArrayList;
import java.util.List;

import util.PrintUtil;

public class ClimibingStaircase {

	public static void main(String[] args) {
		List<List<Integer>> ans = new ClimibingStaircase().climbingStaircase(4, 2);
		PrintUtil.printList(ans);
	}

	public List<List<Integer>> climbingStaircase(int n, int k) {
		List<List<Integer>> ans = new ArrayList<>();
		backTrack(ans, n, k, new ArrayList<Integer>());
		return ans;
	}

	private void backTrack(List<List<Integer>> ll, int n, int k, ArrayList<Integer> l) {
		if (n == 0) {
			ll.add(l);
			return;
		}
		for (int i = 1; i <= k; i++) {
			if (n - i >= 0) {
				l.add(i);
				backTrack(ll, n - i, k, new ArrayList<Integer>(l));
				l.remove(l.size() - 1);
			} else
				return;
		}

	}

}
