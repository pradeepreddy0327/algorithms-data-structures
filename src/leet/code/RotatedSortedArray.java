package leet.code;

public class RotatedSortedArray {
	// leet code 153
	public static void main(String[] args) {
		int[] a = { 3, 4, 5, 1, 2 };
		System.out.println(new RotatedSortedArray().findMin(a));
	}

	public int findMin(int[] nums) {
		return nums[findBegin(nums, 0, nums.length - 1)];
	}

	public int findBegin(int[] nums, int b, int e) {
		if (b >= e)
			return 0;
		if (e - b == 1 && nums[b] > nums[e])
			return e;
		int m = (b + e) / 2;
		if (nums[b] > nums[m]) {
			return findBegin(nums, b, m);
		}
		if (nums[m] > nums[e]) {
			return findBegin(nums, m, e);
		}
		return 0;
	}

}
