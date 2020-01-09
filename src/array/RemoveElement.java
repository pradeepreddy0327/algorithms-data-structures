package array;

public class RemoveElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int removeElement(int[] nums, int val) {
		int l = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[i - l] = nums[i];
			} else {
				l++;
			}
		}
		return nums.length - l;
	}

}
