package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosest {

	public static void main(String[] args) {
        KClosest obj = new KClosest();
        System.out.println(Arrays.deepToString(
                obj.kClosest(new int[][] { { 1, 3 }, { -2, 2 } }, 1)));
        System.out.println(Arrays.deepToString(obj
                .kClosest(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)));

        System.out.println(Arrays.deepToString(
                obj.kClosest2(new int[][] { { 1, 3 }, { -2, 2 } }, 1)));
        System.out.println(Arrays.deepToString(obj
                .kClosest2(new int[][] { { 3, 3 }, { 5, -1 }, { -2, 4 } }, 2)));
	}

	public int[][] kClosest(int[][] points, int K) {
		Arrays.sort(points, (int[] a, int[] b) -> a[0] * a[0] + a[1] * a[1] - b[0] * b[0] - b[1] * b[1]);

		return Arrays.copyOf(points, K);
	}

    public int[][] kClosest2(int[][] points, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (int[] a, int[] b) -> b[0] * b[0] + b[1] * b[1] - a[0] * a[0]
                        - a[1] * a[1]);
        for (int[] p : points) {
            pq.add(p);
            if (pq.size() > K) {
                pq.poll();
            }
        }
        int[][] ans = new int[K][];
        int i = 0;
        while (!pq.isEmpty()) {
            ans[i++] = pq.poll();
        }
        return ans;
    }

}
