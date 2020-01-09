package leet.code.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CutOffTree2 {

	public static void main(String[] args) {
		CutOffTree2 obj = new CutOffTree2();
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

	int[] dr = { -1, 1, 0, 0 };
	int[] dc = { 0, 0, -1, 1 };

	public int cutOffTree(List<List<Integer>> forest) {
		List<int[]> trees = new ArrayList<>();
		for (int r = 0; r < forest.size(); ++r) {
			for (int c = 0; c < forest.get(0).size(); ++c) {
				int v = forest.get(r).get(c);
				if (v > 1)
					trees.add(new int[] { v, r, c });
			}
		}

		Collections.sort(trees, (a, b) -> Integer.compare(a[0], b[0]));

		int ans = 0, sr = 0, sc = 0;
		for (int[] tree : trees) {
			int d = bfs(forest, sr, sc, tree[1], tree[2]);
			if (d < 0)
				return -1;
			ans += d;
			sr = tree[1];
			sc = tree[2];
		}
		return ans;
	}

	public int bfs(List<List<Integer>> forest, int sr, int sc, int tr, int tc) {
		int R = forest.size(), C = forest.get(0).size();
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { sr, sc, 0 });
		boolean[][] seen = new boolean[R][C];
		seen[sr][sc] = true;
		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			if (cur[0] == tr && cur[1] == tc)
				return cur[2];
			for (int di = 0; di < 4; ++di) {
				int r = cur[0] + dr[di];
				int c = cur[1] + dc[di];
				if (0 <= r && r < R && 0 <= c && c < C && !seen[r][c] && forest.get(r).get(c) > 0) {
					seen[r][c] = true;
					queue.add(new int[] { r, c, cur[2] + 1 });
				}
			}
		}
		return -1;
	}
}
