package graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstras {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] adjMatrix = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
		int[] dist = new Dijkstras().dijkstras(adjMatrix, 1);
		System.out.println(Arrays.toString(dist));
	}

	public int[] dijkstras(int[][] adjMatrix, int from) {
		int n = adjMatrix.length;
		int[] dist = new int[n];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		Map<Integer, Node> indexNodeMap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			dist[i] = Integer.MAX_VALUE;
			Node node = new Node(i);
			if (i == from)
				node.distance = 0;
			indexNodeMap.put(i, node);
			pq.add(node);
		}

		while (!pq.isEmpty()) {
			Node minNode = pq.poll();
			dist[minNode.index] = minNode.distance;
			int i = minNode.index;
			int d = minNode.distance;
			for (int j = 0; j < adjMatrix[i].length; j++) {
				if (adjMatrix[i][j] > 0) {
					Node adjNode = indexNodeMap.get(j);
					if (adjNode.distance > d + adjMatrix[i][j]) {
						adjNode.distance = d + adjMatrix[i][j];
						decreasePriority(adjNode, pq);
					}
				}
			}
		}
		return dist;
	}

	private void decreasePriority(Node node, PriorityQueue<Node> pq) {
		pq.remove(node);
		pq.add(node);
	}

}

class Node implements Comparable<Node> {
	Integer index;
	Integer distance;

	Node(int index) {
		this.index = index;
		this.distance = Integer.MAX_VALUE;
	}

	Node(int index, int priority) {
		this.index = index;
		this.distance = priority;
	}

	@Override
	public String toString() {
		return "Node [index=" + index + ", priority=" + distance + "]";
	}

	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return this.distance.compareTo(o.distance);
	}

}