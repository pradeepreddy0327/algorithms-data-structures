package string;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public static void main(String[] args) {
        MinimumWindowSubstring obj = new MinimumWindowSubstring();
        System.out.println(obj.minimumWindowSubstring2("ADOBECODEBANC", "ABC"));
    }

    public String minimumWindowSubstring(String s, String t) {
        Map<Character, Integer> fMap = new HashMap<>();
        char[] tc = t.toCharArray();
        for (char c : tc) {
            Integer f = fMap.get(c) != null ? fMap.get(c) : 0;
            fMap.put(c, f + 1);
        }
        Map<Character, Integer> cfMap = new HashMap<>();
        String ans = "";
        int length = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        while (l <= r && r <= s.length()) {
            if (r - l >= t.length() && isMatch(fMap, cfMap)) {
                if (r - l < length) {
                    length = r - l;
                    ans = s.subSequence(l, r).toString();
                }
                Integer f = cfMap.get(s.charAt(l));
                if (f != null && f > 1) {
                    cfMap.put(s.charAt(l), f - 1);
                } else {
                    cfMap.remove(s.charAt(l));
                }
                l++;
            } else {
                r++;
                if (r <= s.length()) {
                    char c = s.charAt(r - 1);
                    Integer f = cfMap.get(c) != null ? cfMap.get(c) : 0;
                    cfMap.put(c, f + 1);
                }

            }
        }
        return ans;
    }

    private boolean isMatch(Map<Character, Integer> fMap,
            Map<Character, Integer> cfMap) {
        for (Character c : fMap.keySet()) {
            Integer f = cfMap.get(c) != null ? cfMap.get(c) : 0;
            if (f < fMap.get(c)) {
                return false;
            }
        }
        return true;
    }

    public String minimumWindowSubstring2(String s, String t) {
        String ans = "";
        int start = 0, end = 0, counter = t.length(), minL = Integer.MAX_VALUE;
        int[] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        while (end < s.length()) {
            if (map[s.charAt(end)] > 0) {
                counter--;
            }
            map[s.charAt(end)]--;
            end++;
            while (counter == 0) {
                if (end - start < minL) {
                    minL = end - start;
                    ans = s.substring(start, end);
                }
                if (map[s.charAt(start)] == 0) {
                    counter++;
                }
                map[s.charAt(start)]++;
                start++;
            }
        }
        return ans;
    }

}
