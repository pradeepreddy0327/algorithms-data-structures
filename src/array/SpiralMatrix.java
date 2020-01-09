package array;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] m = {{1,11},{2,12},{3,13},{4,14},{5,15},{6,16},{7,17},{8,18},{9,19},{10,20}};
		System.out.println(new SpiralMatrix().spiralOrder(m));
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ll = new ArrayList<>();
		int h = matrix.length;
		if (h == 0)
			return ll;
		int w = matrix[0].length;
		int l = 0, t = 0, r = w - 1, b = h - 1;
		int i = 0;
		while (l <= r - i || t <= b - i) {
			for (int j = l + i; j <= r - i && t + i < (h+1) / 2; j++) {
				ll.add(matrix[t + i][j]);
			}
			for (int j = t + i + 1; j <= b - i && r - i >= w/2; j++) {
				ll.add(matrix[j][r - i]);
			}
			for (int j = r - i - 1; j >= l + i && b - i > t + i; j--) {
				ll.add(matrix[b - i][j]);
			}
			for (int j = b - i - 1; j >= t + i + 1 && l + i < r - i; j--) {
				ll.add(matrix[j][l + i]);
			}
			i++;
		}
		return ll;
	}
}
