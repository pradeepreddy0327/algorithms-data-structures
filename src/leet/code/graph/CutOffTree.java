package leet.code.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// leet code 675
public class CutOffTree {

	public static void main(String[] args) {
		CutOffTree obj = new CutOffTree();
		// Integer[][] array = new Integer[][] { { 1, 2, 3 }, { 0, 0, 4 }, { 7, 6, 5 }
		// };
		Integer[][] array = new Integer[][] { { 54581641, 64080174, 24346381, 69107959 },
				{ 86374198, 61363882, 68783324, 79706116 }, { 668150, 92178815, 89819108, 94701471 },
				{ 83920491, 22724204, 46281641, 47531096 }, { 89078499, 18904913, 25462145, 60813308 } };
		int c = obj.cutOffTree(twoDArrayToList(array));
		System.out.println(c);

	}

	public static <T> List<List<T>> twoDArrayToList(T[][] twoDArray) {
		List<List<T>> list = new ArrayList<>();
		for (T[] array : twoDArray) {
			list.add(Arrays.asList(array));
		}
		return list;
	}

	int[] ir = { -1, 1, 0, 0 };
	int[] ic = { 0, 0, -1, 1 };

	public int cutOffTree(List<List<Integer>> forest) {
		List<int[]> trees = new ArrayList<>();
		for (int i = 0; i < forest.size(); i++) {
			for (int j = 0; j < forest.get(i).size(); j++) {
				int h = forest.get(i).get(j);
				if (h > 1) {
					trees.add(new int[] { i, j, h });
				}
			}
		}
		Collections.sort(trees, (int[] a, int[] b) -> Integer.compare(a[2], b[2]));
		int sr = 0, sc = 0, totalSteps = 0;
		for (int[] tree : trees) {
			int steps = bfs(forest, sr, sc, tree[0], tree[1]);
			if (steps < 0)
				return -1;
			totalSteps += steps;
			sr = tree[0];
			sc = tree[1];
		}
		return totalSteps;
	}

	private int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
		int R = forest.size();
		int C = forest.get(0).size();
		boolean[][] v = new boolean[R][C];
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { sr, sc, 0 });
		v[sr][sc] = true;
		while (!q.isEmpty()) {
			int[] cell = q.poll();
			if (cell[0] == tr && cell[1] == tc)
				return cell[2];
			for (int i = 0; i < 4; i++) {
				int nr = cell[0] + ir[i];
				int nc = cell[1] + ic[i];
				if (nr >= 0 && nr < R && nc >= 0 && nc < C && !v[nr][nc] && forest.get(nr).get(nc) > 0) {
					v[nr][nc] = true;
					q.add(new int[] { nr, nc, cell[2] + 1 });
				}
			}
		}
		return -1;
	}

}
