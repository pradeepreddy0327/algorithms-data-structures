package leet.code.graph;

public class HasCycleUndirectedGraph {

	public static void main(String[] args) {
		int[][] m = { { 1 }, { 2 }, { 3, 4 }, { 4 }, { 0 } };
		int[][] n = { { 1, 2, 3 }, {2}, {}, {} };
		System.out.println(new HasCycleUndirectedGraph().hasCycle(n));
		System.out.println(new HasCycleUndirectedGraph().hasCycle(m));
	}

	public boolean hasCycle(int[][] adjMatrix) {
		int n = adjMatrix.length;
		boolean[] v = new boolean[n];
		for (int i = 0; i < v.length; i++) {
			if (!v[i]) {
				if (hasCycle(i, v, adjMatrix, -1))
					return true;
			}
		}
		return false;
	}

	private boolean hasCycle(int i, boolean[] v, int[][] adjMatrix, int p) {
		v[i] = true;
		for (int j : adjMatrix[i]) {
			if (v[j] && j != p) {
				return true;
			}
			if (!v[j]) {
				if (hasCycle(j, v, adjMatrix, i)) {
					return true;
				}
			}
		}
		return false;
	}

}
