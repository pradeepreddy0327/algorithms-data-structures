package priorityqueue;

// Leet code
public class MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		int[] a = { 1, 3 };
		int[] b = { 2 };
		System.out.println(new MedianOfTwoSortedArrays().meadianOfTwoSortedArrays(a, b));
	}

	public double meadianOfTwoSortedArrays(int[] a, int[] b) {
		int x = a.length;
		int y = b.length;
		if (y < x) {
			return meadianOfTwoSortedArrays(b, a);
		}
		int low = 0;
		int high = x;
		while (low <= high) {
			int partitionX = (low + high) / 2;
			int partitionY = (x + y + 1) / 2 - partitionX;

			int maxLeftX = partitionX <= 0 ? Integer.MIN_VALUE : a[partitionX - 1];
			int maxLeftY = partitionY <= 0 ? Integer.MIN_VALUE : b[partitionY - 1];

			int minRightX = partitionX >= x ? Integer.MAX_VALUE : a[partitionX];
			int minRightY = partitionY >= y ? Integer.MAX_VALUE : b[partitionY];
			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				if ((x + y) % 2 == 0) {
					return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
				} else {
					return Math.max(maxLeftX, maxLeftY);
				}
			} else if (maxLeftX > minRightY) {
				high = partitionX - 1;
			} else {
				low = partitionX + 1;
			}
		}
		throw new IllegalArgumentException();
	}

}
