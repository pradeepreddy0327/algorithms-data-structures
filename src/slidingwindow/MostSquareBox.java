package slidingwindow;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MostSquareBox {

    public static void main(String[] args) {
        MostSquareBox obj = new MostSquareBox();
        System.out.println(Arrays.toString(obj.mostSquareBox(802)));
        TreeMap<int[], Integer> map = new TreeMap<>(
                (a, b) -> b[0] - b[1] - a[0] + a[1]);
        for (int i = 1; i < 1000; i++) {
            int[] ans = obj.mostSquareBox(i);
            if (ans[0] - ans[1] > 5) {
                map.put(ans, i);
            }
        }
        for (Entry<int[], Integer> entry : map.entrySet()) {
            System.out.println("Input: " + entry.getValue() + " Answer: "
                    + Arrays.toString(entry.getKey()));
        }
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
