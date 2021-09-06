package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConcatStrings {

    public static void main(String[] args) {
        WordBreak2 obj = new WordBreak2();
        System.out.println(obj.wordBreak("catsanddog", Arrays
                .asList(new String[]{"cat", "cats", "and", "sand", "dog"})));
        System.out.println(
                obj.wordBreak("pineapplepenapple", Arrays.asList(new String[]{
                        "apple", "pen", "applepen", "pine", "pineapple"})));

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String>[] dp = new ArrayList[s.length()];
        for(int i=0;i<s.length();i++){
            dp[i]=new ArrayList<>();
        }
        Boolean[] mem = new Boolean[s.length()];
        bfs(s, new HashSet<>(wordDict), 0, dp, mem);
        return dp[0];
    }

    private boolean bfs(String s, Set<String> wordDict, int i, List<String>[] dp, Boolean[] mem) {
        if (i == s.length()) return true;
        if (mem[i] != null) return mem[i];
        for (int j = i + 1; j <= s.length(); j++) {
            if (wordDict.contains(s.substring(i, j)) && bfs(s, wordDict, j, dp, mem)) {
                mem[i] = true;
                if (j < s.length()) {
                    for (String p : dp[j]) {
                        dp[i].add(s.substring(i, j) + " " + p);
                    }
                } else {
                    dp[i].add(s.substring(i, j));
                }
            }
        }
        if (mem[i] == null) {
            mem[i] = false;
        }
        return mem[i];
    }
}
