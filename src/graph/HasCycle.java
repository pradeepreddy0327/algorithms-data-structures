package graph;

public class HasCycle {

	public static void main(String[] args) {
		int[][] m = { { 1 }, { 2 }, { 3, 4 }, { 4 }, { 0 } };
		int[][] n = { { 1, 2, 3 }, { 2, 3 }, { 3 }, {} };
		System.out.println(new HasCycle().hasCycle(n));
		System.out.println(new HasCycle().hasCycle(m));
	}

	public boolean hasCycle(int[][] adjMatrix) {
		int n = adjMatrix.length;
		boolean[] v = new boolean[n];
		boolean[] parent = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (!v[i]) {
				if (hasCycle(i, v, parent, adjMatrix)) {
					return true;
				}
			}
		}

		return false;
	}

	private boolean hasCycle(int i, boolean[] v, boolean[] parent, int[][] adjMatrix) {
		v[i] = true;
		parent[i] = true;
		for (int j : adjMatrix[i]) {
			if (parent[j])
				return true;
			if (!v[j]) {
				if (hasCycle(j, v, parent, adjMatrix)) {
					return true;
				}
			}
		}
		parent[i] = false;
		return false;
	}

}
