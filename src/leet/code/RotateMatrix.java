package leet.code;

import java.util.Arrays;

public class RotateMatrix {

    public static void main(String[] args) {
        int[][] m = new int[][] { { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 },
                { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 }, { 1, 2, 3, 4, 5 } };
        RotateMatrix obj = new RotateMatrix();
        System.out.println(Arrays.deepToString(obj.rotate(m)));
    }

    public int[][] rotate(int[][] m) {

        int N = m.length;
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j < N - i - 1; j++) {

                int a = j;
                int b = N - i - 1;

                int c = b;
                int d = N - a - 1;

                int e = d;
                int f = N - c - 1;

                int t = m[i][j];
                m[i][j] = m[e][f];
                m[e][f] = m[c][d];
                m[c][d] = m[a][b];
                m[a][b] = t;
            }
        }
        return m;
    }

}
