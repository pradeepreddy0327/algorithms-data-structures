package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import util.PrintUtil;

public class PrimsMST {

	public static void main(String[] args) {
		int[][] adjMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		int[][] adj2 = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 }, { 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 },
				{ 0, 5, 7, 9, 0 } };
		List<Edge> mst = new PrimsMST().primsMST(adjMatrix);
		List<Edge> mst2 = new PrimsMST().primsMST(adj2);
		PrintUtil.printList(mst);
		PrintUtil.printList(mst2);
	}

	public List<Edge> primsMST(int[][] adjMatrix) {
		int n = adjMatrix.length;
		List<Edge> mst = new ArrayList<>();
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		Map<Integer, Edge> indexEdgeMap = new HashMap<>();
		boolean[] v = new boolean[n];
		for (int i = 0; i < n; i++) {
			Edge edge = new Edge(i);
			if (i == 0)
				edge.weight = 0;
			indexEdgeMap.put(i, edge);
			pq.add(edge);
		}
		while (!pq.isEmpty()) {
			Edge minEdge = pq.poll();
			if (minEdge.from != -1)
				mst.add(minEdge);
			int i = minEdge.to;
			v[i] = true;
			for (int j = 0; j < adjMatrix[i].length; j++) {
				if (!v[j] && adjMatrix[i][j] > 0) {
					Edge edge = indexEdgeMap.get(j);
					if (edge.weight > adjMatrix[i][j]) {
						edge.weight = adjMatrix[i][j];
						edge.from = i;
						decreasePriority(edge, pq);
					}
				}
			}
		}
		return mst;
	}

	private void decreasePriority(Edge node, PriorityQueue<Edge> pq) {
		pq.remove(node);
		pq.add(node);
	}

}
