package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

// lc 1153
public class CanConvert {

    public static void main(String[] args) {
        CanConvert obj = new CanConvert();
        System.out.println(obj.canConvert("aabcc", "ccdee"));
        System.out.println(obj.canConvert("leetcode", "codeleet"));
        System.out.println(obj.canConvert("abcdefghijklmnopqrstuvwxyz",
                "bcdefghijklmnopqrstuvwxyzq"));
        System.out.println(obj.canConvert2("abcdefghijklmnopqrstuvwxyz",
                "bcdefghijklmnopqrstuvwxyzq"));
    }

    public boolean canConvert(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        if (str1.equals(str2)) {
            return true;
        }
        LinkedHashMap<Character, List<Integer>> charIndexMap1 = new LinkedHashMap<>();
        LinkedHashMap<Character, List<Integer>> charIndexMap2 = new LinkedHashMap<>();

        for (int i = 0; i < str1.length(); i++) {
            addCharIndex(charIndexMap1, i, str1.charAt(i));
            addCharIndex(charIndexMap2, i, str2.charAt(i));
        }
        if (charIndexMap1.size() != charIndexMap2.size()) {
            return false;
        }
        if (charIndexMap1.size() == 26) {
            return false;
        }
        Iterator<List<Integer>> it1 = charIndexMap1.values().iterator();
        Iterator<List<Integer>> it2 = charIndexMap2.values().iterator();
        while (it1.hasNext()) {
            if (!it1.next().equals(it2.next())) {
                return false;
            }
        }
        return true;
    }

    private void addCharIndex(
            LinkedHashMap<Character, List<Integer>> charIndexMap, int i,
            char c) {
        List<Integer> indexes = charIndexMap.get(c);
        if (indexes == null) {
            indexes = new ArrayList<Integer>();
            charIndexMap.put(c, indexes);
        }
        indexes.add(i);

    }

    public boolean canConvert2(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        if (a.equals(b)) {
            return true;
        }

        Map<Character, Character> c = new HashMap<>();
        int l = a.length();

        for (int i = 0; i < l; i++) {
            char aa = a.charAt(i);
            char bb = b.charAt(i);

            if (c.getOrDefault(aa, bb) == bb) {
                c.put(aa, bb);
            } else {
                return false;
            }
        }

        if (c.keySet().size() == new HashSet<Character>(c.values()).size()) {
            return c.size() != 26;
        }
        return true;
    }
}
