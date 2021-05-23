package leetcode;

import java.util.Arrays;

public class MostSquareBox {

    public static void main(String[] args) {
        MostSquareBox obj = new MostSquareBox();
        System.out.println(Arrays.toString(obj.mostSquareBox(84)));
    }

    public int[] mostSquareBox(int n) {
        int x = (int) Math.ceil(Math.sqrt(n));
        int y = x;
        while (x * y < n || x * y > n + 2) {
            if (x * y < n) {
                x++;
            } else {
                y--;
            }
        }
        return new int[] { x, y };
    }
}
