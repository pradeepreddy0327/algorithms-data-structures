package search;

public class SearchInsertPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int searchInsert(int[] nums, int target) {

		return binarySearch(nums, 0, nums.length - 1, target);
	}

	public int binarySearch(int[] nums, int start, int end, int target) {
		if (start >= end) {
			return nums[start] >= target ? start : start + 1;
		}
		int mid = (start + end) / 2;
		if (target == nums[mid])
			return mid;
		else if (target > nums[mid])
			return binarySearch(nums, mid + 1, end, target);
		return binarySearch(nums, start, mid - 1, target);
	}

}
