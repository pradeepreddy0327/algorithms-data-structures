package graph;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircles {

	public int findCircleNum(int[][] M) {
		int ans = 0;
		boolean[] v = new boolean[M.length];
		int k = 0;
		while (k > -1) {
			ans++;
			Queue<Integer> q = new LinkedList<>();
			q.add(k);
			while (!q.isEmpty()) {
				k = q.remove();
				v[k] = true;
				for (int i = 0; i < M.length; i++) {
					if (i != k && !v[i] && (M[i][k] == 1 || M[k][i] == 1))
						q.add(i);
				}
			}
			k = getFirstFalseIndex(v);
		}
		return ans;
	}

	public int getFirstFalseIndex(boolean[] v) {
		for (int i = 0; i < v.length; i++) {
			if (!v[i])
				return i;
		}
		return -1;
	}
}