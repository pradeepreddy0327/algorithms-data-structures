package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public static void main(String[] args) {
        GroupAnagrams obj = new GroupAnagrams();
        System.out.println(obj.groupAnagrams(
                new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
        System.out.println(obj.groupAnagrams2(
                new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            char[] sc = s.toCharArray();
            Arrays.sort(sc);
            String key = new String(sc);
            List<String> group = anagramMap.get(key);
            if (group == null) {
                group = new ArrayList<String>();
                anagramMap.put(key, group);
            }
            group.add(s);
        }
        return new ArrayList<>(anagramMap.values());
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            char[] sc = s.toCharArray();
            int[] freqArr = new int[26];
            for (int i = 0; i < sc.length; i++) {
                freqArr[sc[i] - 'a']++;
            }
            String key = Arrays.toString(freqArr);
            List<String> group = anagramMap.get(key);
            if (group == null) {
                group = new ArrayList<String>();
                anagramMap.put(key, group);
            }
            group.add(s);
        }
        return new ArrayList<>(anagramMap.values());
    }

}
