package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumSquares {

    public static void main(String[] args) {
        NumSquares obj = new NumSquares();
        obj.numSquares(100);
    }

    public int numSquares(int n) {
        if (n <= 1)
            return n;
        int[] arr = new int[n];
        arr[0] = 1;
        arr[1] = 2;
        List<Integer> squares = new ArrayList<>();
        squares.add(1);
        int nextSqrt = 2;
        int nextSquare = 4;
        for (int i = 2; i < n; i++) {
            if (nextSquare == i + 1) {
                squares.add(nextSquare);
                arr[i] = 1;
                nextSqrt++;
                nextSquare = nextSqrt * nextSqrt;
            } else {
                arr[i] = getMinSquares(arr, i, squares);
            }
        }
        System.out.println(Arrays.toString(arr));
        return arr[n - 1];
    }

    private int getMinSquares(int[] arr, int n, List<Integer> squares) {
        int min = Integer.MAX_VALUE;
        for (Integer square : squares) {
            min = Math.min(min, 1 + arr[n - square]);
        }
        return min;
    }

}
