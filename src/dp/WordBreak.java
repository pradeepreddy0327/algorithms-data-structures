package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// lc 139
public class WordBreak {

    public static void main(String[] args) {
        WordBreak obj = new WordBreak();
        System.out.println(obj.wordBreak("applepenapple", new ArrayList<String>(
                Arrays.asList(new String[] { "apple", "pen" }))));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] mem = new Boolean[s.length() + 1];
        return backTrack(s, wordDict, 0, mem);
    }

    private boolean backTrack(String s, List<String> wordDict, int start,
            Boolean[] mem) {
        if (start == s.length()) {
            return true;
        }
        if (mem[start] != null) {
            return mem[start];
        }
        for (int i = start + 1; i <= s.length(); i++) {
            if (wordDict.contains(s.substring(start, i))
                    && backTrack(s, wordDict, i, mem)) {
                mem[i] = backTrack(s, wordDict, i, mem);
                if (mem[i]) {
                    return true;
                }
            }
        }
        mem[start] = false;
        return mem[start];
    }

}
