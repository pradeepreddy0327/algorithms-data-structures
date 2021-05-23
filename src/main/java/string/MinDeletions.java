package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class MinDeletions {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Siblings".hashCode());
        System.out.println("Teheran".hashCode());
        System.out.println("Siblings".equals("Teheran"));
        System.out.println("Siblings".compareTo("Teheran"));
        Map<String, String> map = new HashMap<>();
        map.put("Siblings", "Siblings");
        map.put("Teheran", "Teheran");
        System.out.println(map);

    }

    public int minDeletions(String s) {
        Map<Character, Integer> charFreqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            int freq = charFreqMap.getOrDefault(c, 0);
            charFreqMap.put(c, freq + 1);
        }
        Map<Integer, int[]> tm = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (Entry<Character, Integer> entry : charFreqMap.entrySet()) {
            int[] a = tm.get(entry.getValue());
            if (!tm.containsKey(entry.getValue())) {
                a = new int[] { entry.getValue(), 0 };
                pq.add(a);
            }
            a[1]++;
            tm.put(entry.getValue(), a);
        }
        int count = 0;
        while (!pq.isEmpty()) {
            int[] a = pq.poll();
            if (a[1] > 1) {
                count += a[1] - 1;
                if (!tm.containsKey(a[0] - 1)) {

                }
            }
        }
        return count;
    }
}
