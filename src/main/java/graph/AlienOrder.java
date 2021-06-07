package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// leetcode 269  tags: Facebook
public class AlienOrder {

    public static void main(String[] args) {
        AlienOrder obj = new AlienOrder();
        System.out.println(obj.alienOrder(
                new String[] { "wrt", "wrf", "er", "ett", "rftt" }));
        System.out.println(obj.alienOrder(new String[] { "z", "x" }));
        System.out.println(obj.alienOrder(new String[] { "z", "x", "z" }));
        System.out.println(
                obj.alienOrder(new String[] { "za", "zb", "ca", "cb" }));
        System.out.println(
                obj.alienOrder(new String[] { "abc", "ab" }));
    }

    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        int[] incoming = new int[26];
        for (int i = 0; i < words.length - 1; i++) {
            int j = 0;
            int minL = Math.min(words[i].length(), words[i + 1].length());
            while (j < minL) {
                if (words[i].charAt(j) != words[i + 1].charAt(j)) {
                    List<Character> adjList = graph.getOrDefault(
                            words[i].charAt(j), new ArrayList<>());
                    if (!adjList.contains(words[i + 1].charAt(j))) {
                        adjList.add(words[i + 1].charAt(j));
                        graph.put(words[i].charAt(j), adjList);
                        incoming[words[i + 1].charAt(j) - 'a']++;
                    }
                    break;
                }
                j++;
            }
        }
        System.out.println(graph);
        System.out.println(Arrays.toString(incoming));
        Queue<Character> q = new LinkedList<>();
        StringBuffer sb = new StringBuffer();
        Set<Character> allChars = getAllChars(words);
        for (Character c : allChars) {
            if (incoming[c - 'a'] == 0) {
                q.add(c);
            }
        }
        while (!q.isEmpty()) {
            Character c = q.poll();
            sb.append(c);
            if (graph.containsKey(c)) {
                for (Character adj : graph.get(c)) {
                    incoming[adj - 'a']--;
                    if (incoming[adj - 'a'] == 0) {
                        q.add(adj);
                    }
                }
            }
        }
        return allChars.size() == sb.toString().length() ? sb.toString() : "";
    }

    private Set<Character> getAllChars(String[] words) {
        Set<Character> allChars = new HashSet<Character>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                allChars.add(c);
            }
        }
        return allChars;
    }
}
