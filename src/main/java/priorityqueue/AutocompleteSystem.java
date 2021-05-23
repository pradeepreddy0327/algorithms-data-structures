package priorityqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//lc 642
public class AutocompleteSystem {

    public static void main(String[] args) {
        System.out.println('i');
        AutocompleteSystem obj = new AutocompleteSystem(new String[] {"i love you",
                "island",
                "ironman",
                        "i love leetcode" },
                new int[] { 5, 3, 2, 2 });
        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));
        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));
        System.out.println(obj.input('i'));
        System.out.println(obj.input(' '));
        System.out.println(obj.input('a'));
        System.out.println(obj.input('#'));

    }
    int returnSize = 3;
    Map<String, Integer> map;
    String current = "";
    public AutocompleteSystem(String[] sentences, int[] times) {
        map = new HashMap<>();
        int i = 0;
        for(String s:sentences) {
            map.put(s, times[i++]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            int freq = map.getOrDefault(current, 0) + 1;
            map.put(current, freq);
            current = "";
            return new ArrayList<String>();
        }
        current += c;
        PriorityQueue<Entry> pq = new PriorityQueue<Entry>(
                (a, b) -> (a.value != b.value ? a.value - b.value
                        : b.key.compareTo(a.key)));
        for (String key : map.keySet()) {
            if (key.indexOf(current) == 0) {
                pq.add(new Entry(key, map.get(key)));
            }
            if (pq.size() > returnSize) {
                pq.poll();
            }
        }
        List<String> ans = new ArrayList<String>();
        while (!pq.isEmpty()) {
            ans.add(pq.poll().key);
        }
        Collections.reverse(ans);
        return ans;
    }

    class Entry {
        Integer value;
        String key;

        Entry(String key, Integer value) {
            this.key = key;
            this.value = value;
        }
        
    }
}
