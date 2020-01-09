package leet.code.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.PrintUtil;

public class KruskalMST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] adjMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		int[][] adj2 = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };
		Edge[] mst = new KruskalMST().findMST(adjMatrix);
		Edge[] mst2 = new KruskalMST().findMST(adj2);
		PrintUtil.printArray(mst);
		PrintUtil.printArray(mst2);
	}

	public Edge[] findMST(int[][] adjMatrix) {
		int n = adjMatrix.length;
		List<Edge> edges = new ArrayList<>();
		Edge[] mstEdges = new Edge[n - 1];
		SubSet[] subSets = new SubSet[n];
		for (int i = 0; i < n; i++) {
			subSets[i] = new SubSet(i, 0);
		}
		int k = 0;

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (adjMatrix[i][j] > 0)
					edges.add(new Edge(i, j, adjMatrix[i][j]));
			}
		}
		Collections.sort(edges);
		for (int i = 0; i < edges.size() && k < n - 1; i++) {
			Edge e = edges.get(i);
			int x = SubSet.find(subSets, e.from);
			int y = SubSet.find(subSets, e.to);

			if (x != y) {
				mstEdges[k++] = e;
				SubSet.union(subSets, x, y);
			}
		}

		return mstEdges;
	}

}
