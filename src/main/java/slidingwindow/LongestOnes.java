package slidingwindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LongestOnes {

    public static void main(String[] args) {
        LongestOnes obj = new LongestOnes();
        System.out.println(obj
                .longestOnes(new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
        System.out.println(obj.longestOnes2(
                new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));
        System.out.println(obj.longestOnes3(
                new int[] { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 }, 2));

    }

    public int longestOnes(int[] A, int K) {
        if (A.length == K) {
            return A.length;
        }
        if (K == 0) {
            return consecutiveOnes(A);
        }
        Queue<Integer> lq = new LinkedList<Integer>();
        Queue<Integer> rq = new LinkedList<Integer>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                lq.add(i);
                rq.add(i);
            }
        }
        if (lq.size() <= K) {
            return A.length;
        }
        int left = 0;
        int right = 0;

        int count = 0;
        while (count < K - 1) {
            right = rq.poll();
            count++;
        }
        int longestOnes = 0;
        while (!rq.isEmpty()) {
            left = lq.poll();
            right = rq.poll();
            longestOnes = Math.max(longestOnes, countOnes(A, left, right));
        }
        return longestOnes;
    }

    public int longestOnes2(int[] A, int K) {
        if (A.length == K) {
            return A.length;
        }
        if (K == 0) {
            return consecutiveOnes(A);
        }
        List<int[]> zeros = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                if (zeros.size() > 0) {
                    zeros.get(zeros.size() - 1)[2] = count;
                }
                zeros.add(new int[] { i, count, 0 });
                count = 0;
            } else {
                count++;
            }
        }
        if (zeros.size() > 0) {
            zeros.get(zeros.size() - 1)[2] = count;
        }
        if (zeros.size() <= K) {
            return A.length;
        }
        int index = 0;
        int longestOnes = 0;
        while (index + K - 1 < zeros.size()) {
            int[] left = zeros.get(index);
            int[] right = zeros.get(index + K - 1);
            int ones = left[1] + right[2] + (right[0] - left[0] + 1);
            longestOnes = Math.max(longestOnes, ones);
            index++;
        }
        return longestOnes;
    }

    public int longestOnes3(int[] A, int K) {
        if (A.length == K) {
            return A.length;
        }
        int left = 0;
        int right = 0;
        int longestOnes = 0;
        if (A[0] == 0) {
            K--;
        }
        while (right < A.length) {

            if (K >= 0) {
                longestOnes = Math.max(longestOnes, right - left + 1);
            }
            while (K < 0 && left < right) {
                if (A[left] == 0) {
                    K++;
                }
                left++;
            }
            right++;
            if (right < A.length && A[right] == 0) {
                K--;
            }
        }

        return longestOnes;
    }

    private int consecutiveOnes(int[] A) {
        int count = 0;
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0) {
                count = 0;
            } else {
                count++;
                max = Math.max(count, max);
            }
        }
        return max;
    }

    private int countOnes(int[] A, int left, int right) {
        int leftOnes = 0;
        int rightOnes = 0;
        int i = left - 1;
        while (i >= 0 && A[i] == 1) {
            leftOnes++;
            i--;
        }
        i = right + 1;
        while (i < A.length && A[i] == 1) {
            rightOnes++;
            i++;
        }
        return rightOnes + leftOnes + (right - left + 1);
    }
}
