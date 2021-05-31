package queue;

// leetcode 1695
public class MaximumErasureValue {
    public static void main(String[] args) {
        System.out.println(MaximumErasureValue.maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6}));
        System.out.println(MaximumErasureValue.maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}));
    }

    public static int maximumUniqueSubarray(int[] nums) {
        boolean[] visited = new boolean[10001];
        int maxSum = 0;
        int runningSum = 0;
        int startIndex = 0;
        for (int i : nums) {
            while (visited[i]) {
                int j = nums[startIndex++];
                runningSum -= j;
                visited[j] = false;
                if (i == j) break;
            }
            runningSum += i;
            maxSum = Math.max(runningSum, maxSum);
            visited[i] = true;
        }
        return maxSum;
    }
}
