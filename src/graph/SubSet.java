package graph;

public class SubSet {

	int parent;
	int rank;

	public SubSet(int parent, int rank) {
		this.parent = parent;
		this.rank = rank;
	}

	public static int find(SubSet[] arr, int i) {
		if (arr[i].parent != i) {
			return find(arr, arr[i].parent);
		}
		return i;
	}

	public static void union(SubSet[] arr, int i, int j) {
		i = find(arr, i);
		j = find(arr, j);

		if (arr[i].rank > arr[j].rank) {
			arr[j].parent = i;
		} else if (arr[j].rank > arr[i].rank) {
			arr[i].parent = j;
		} else {
			arr[j].parent = i;
			arr[i].rank++;
		}
	}
}
