package leet.code.graph;

class Edge implements Comparable<Edge> {
	Integer from;
	Integer to;
	Integer weight;

	Edge(int to) {
		this.to = to;
		this.from = -1;
		this.weight = Integer.MAX_VALUE;
	}

	Edge(int from, int to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	@Override
	public int compareTo(Edge o) {
		return this.weight.compareTo(o.weight);
	}

	@Override
	public String toString() {
		return "from=" + from + ", to=" + to + ", weight=" + weight;
	}

}