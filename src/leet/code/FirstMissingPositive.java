package leet.code;

public class FirstMissingPositive {

    public static void main(String[] args) {
        FirstMissingPositive fmp = new FirstMissingPositive();

        System.out.println(fmp.firstMissingPositive(new int[] { 3, 4, 2, 1 }));
    }

    public int firstMissingPositive(int[] nums) {

        int i = 0;
        while (i < nums.length) {
            int j = nums[i];
            if (j - 1 == i || j <= 0 || j > nums.length) {
                i++;
            } else {
                boolean b = true;
                while (b) {
                    int t = nums[j - 1];
                    nums[j - 1] = j;
                    if (t == j || t <= 0 || t > nums.length) {
                        b = false;
                    }
                    j = t;
                }
                i++;
            }
        }
        i = 0;
        while (i < nums.length) {
            if (i + 1 == nums[i]) {
                i++;
            } else {
                break;
            }
        }
        return i + 1;
    }
}
