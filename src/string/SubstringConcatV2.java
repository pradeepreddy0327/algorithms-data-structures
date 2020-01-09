package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SubstringConcatV2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SubstringConcatV2 obj = new SubstringConcatV2();
        System.out.println(obj.findSubstring("barfoothefoobarman",
                new String[] { "foo", "bar" }));
        System.out.println(obj.findSubstring("wordgoodgoodgoodbestword",
                new String[] { "word", "good", "best", "word" }));
        System.out.println(obj.findSubstring("aaa", new String[] { "a", "a" }));
    }

    int wordLength = 0;
    int arrLength = 0;

    public List<Integer> findSubstring(String s, String[] words) {
        TreeMap<Integer, String> map = new TreeMap<>();
        Map<String, Integer> freqMap = new HashMap<>();
        arrLength = words.length;
        wordLength = arrLength > 0 ? words[0].length() : 0;
        List<Integer> ans = new ArrayList<>();
        if (s.length() < wordLength * arrLength) {
            return ans;
        }
        for (int i = 0; i < words.length; i++) {
            addIndeces(s, words[i], i, map);
            Integer freq = freqMap.get(words[i]);
            if (freq == null) {
                freq = 0;
            }
            freq++;
            freqMap.put(words[i], freq);
        }
        System.out.println(freqMap.toString());

        for (Integer j : map.keySet()) {
            if (s.length() - j < arrLength * wordLength) {
                break;
            }
            if (isSub(map, j, new HashMap<String, Integer>(freqMap), 0)) {
                ans.add(j);
            }
        }
        return ans;
    }

    private boolean isSub(TreeMap<Integer, String> map, Integer j,
            HashMap<String, Integer> freqMap, int k) {
        String sub = map.get(j);
        if (sub == null) {
            return false;
        }
        if (freqMap.get(sub) >= 1) {
            freqMap.put(sub, freqMap.get(sub) - 1);
            k++;
            return k == arrLength || isSub(map, j + wordLength, freqMap, k);
        }

        return false;
    }

    private void addIndeces(String s, String sub, int i,
            TreeMap<Integer, String> map) {
        for (int j = 0; j + sub.length() <= s.length(); j++) {
            if (s.substring(j, j + sub.length()).equals(sub)) {
                map.put(j, sub);
            }
        }

    }

}
