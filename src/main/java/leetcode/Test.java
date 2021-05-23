package leetcode;

import java.io.IOException;

public class Test {

    public static void main(String[] args) throws IOException {
        System.out.println(getHashCode("000A"));
        System.out.println(getHashCode("000AB"));
        System.out.println(getHashCode("cAr1"));
        System.out.println(getHashCode("cAr1a"));
        System.out.println(108738449 * 131 % MOD);

    }

    static int MOD = 1000000007;

    private static long getHashCode(String s) {
        long hash = 0l;
        for (int i = 0; i < s.length(); i++) {
            hash = (((hash * 131) % MOD) + s.charAt(i)) % MOD;
        }
        return hash;
    }
}
