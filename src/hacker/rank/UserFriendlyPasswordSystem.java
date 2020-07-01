package hacker.rank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserFriendlyPasswordSystem {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    static int MOD = 1000000007;
    static char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890"
            .toCharArray();

    public static List<Integer> authEvents(List<List<String>> events) {
        Set<Long> hashes = new HashSet<Long>();
        List<Integer> ans = new ArrayList<>();
        for (List<String> event : events) {
            if (event.get(0).equals("setPassword")) {
                hashes = new HashSet<Long>();
                addHash(event.get(1), hashes);
                System.out.println(hashes);
            } else {
                ans.add(hashes.contains(Long.valueOf(event.get(1))) ? 1 : 0);
            }
        }
        return ans;
    }

    private static void addHash(String s, Set<Long> set) {
        long hash = getHashCode(s);
        set.add(hash);
        for (char c : chars) {
            set.add(((hash * 131) % MOD + c) % MOD);
        }
    }

    private static long getHashCode(String s) {
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash = ((hash * 131) % MOD + s.charAt(i)) % MOD;
        }
        return hash;
    }

}
