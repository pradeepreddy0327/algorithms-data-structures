package dp;

// leet code problem : 10
public class RegEx {

    public static void main(String[] args) {
        RegEx obj = new RegEx();
        System.out.println(obj.isMatchDpBottomUp("aab", ".*"));
    }

    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty()
                && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2))
                    || (firstMatch && isMatch(s.substring(1), p));
        }
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }

    Boolean[][] dp;

    public boolean isMatchDp(String s, String p) {
        if (dp == null) {
            dp = new Boolean[s.length() + 1][p.length() + 1];
        }
        if (dp[s.length()][p.length()] != null) {
            return dp[s.length()][p.length()];
        }
        boolean ans = false;
        if (p.isEmpty()) {
            ans = s.isEmpty();
        } else {
            boolean firstMatch = !s.isEmpty()
                    && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
            if (p.length() >= 2 && p.charAt(1) == '*') {
                ans = isMatchDp(s, p.substring(2))
                        || (firstMatch && isMatchDp(s.substring(1), p));
            } else {
                ans = firstMatch && isMatchDp(s.substring(1), p.substring(1));
            }
        }
        dp[s.length()][p.length()] = ans;
        return dp[s.length()][p.length()];

    }

    public boolean isMatchDpBottomUp(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[s.length()][p.length()] = true;
        for (int i = s.length(); i >= 0; i--) {
            for (int j = p.length() - 1; j >= 0; j--) {
                boolean firstMatch = i < s.length()
                        && (p.charAt(j) == '.' || s.charAt(i) == p.charAt(j));
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = dp[i][j + 2] || (firstMatch && dp[i + 1][j]);
                } else {
                    dp[i][j] = firstMatch && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

}
