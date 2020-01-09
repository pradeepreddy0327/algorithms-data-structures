package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// lc 140
public class WordBreak2 {

    public static void main(String[] args) {
        WordBreak2 obj = new WordBreak2();
        System.out.println(obj.wordBreak("catsanddog", Arrays
                .asList(new String[] { "cat", "cats", "and", "sand", "dog" })));
        System.out.println(
                obj.wordBreak("pineapplepenapple", Arrays.asList(new String[] {
                        "apple", "pen", "applepen", "pine", "pineapple" })));

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Boolean[] mem = new Boolean[s.length()];
        List<String>[] l = new ArrayList[s.length()];
        for (int i = 0; i < s.length(); i++) {
            l[i] = new ArrayList<String>();
        }
        backTrack(s, wordDict, 0, mem, l);
        return l[0];
    }

    private boolean backTrack(String s, List<String> wordDict, int i,
            Boolean[] mem, List<String>[] l) {
        if (i == s.length()) {
            return true;
        }
        if (mem[i] != null) {
            return mem[i];
        }
        for (int j = i + 1; j <= s.length(); j++) {
            if (wordDict.contains(s.substring(i, j))
                    && backTrack(s, wordDict, j, mem, l)) {
                mem[i] = true;
                if (j < l.length) {
                    for (String p : l[j]) {
                        l[i].add(s.substring(i, j) + " " + p);
                    }
                } else {
                    l[i].add(s.substring(i, j));
                }
            }
        }
        if (mem[i] == null) {
            mem[i] = false;
        }
        return mem[i];
    }

}
