package array;

import java.util.Arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater obj = new TrappingRainWater();
        System.out.println(
                obj.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));

    }

    public int trap(int[] arr) {
        int[][] maxArr = new int[arr.length][2];
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < arr.length; i++) {
            leftMax = i > 0 ? Math.max(arr[i - 1], leftMax) : 0;
            rightMax = i > 0 ? Math.max(arr[arr.length - i], rightMax) : 0;
            maxArr[i][0] = leftMax;
            maxArr[arr.length - i - 1][1] = rightMax;
        }
        System.out.println(Arrays.deepToString(maxArr));
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            int h = Math.min(maxArr[i][0], maxArr[i][1]) - arr[i];
            if (h > 0) {
                ans += h;
            }
        }
        return ans;
    }

}
