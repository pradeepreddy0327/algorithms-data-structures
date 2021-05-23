package dp;

public class EditDistance {

    public static void main(String[] args) {
        EditDistance obj = new EditDistance();
        System.out.println(obj.editDistance("sea", "eat"));
        System.out.println(
                obj.dpTopDown(
                "pneumonoultramicroscopicsilicovolcanoconiosis",
                "ultramicroscopically"));
        System.out.println(obj.editDistance(
                "pneumonoultramicroscopicsilicovolcanoconiosis",
                "ultramicroscopically"));
        System.out.println(obj.dpTopDown("sea", "eat"));
        System.out.println(obj.editDistance("dinitrophenylhydrazine",
                "acetylphenylhydrazine"));
        System.out.println(obj.dpTopDown("dinitrophenylhydrazine",
                "acetylphenylhydrazine"));

    }

    public int editDistance(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return Math.max(a.length(), b.length());
        }
        int[][] dp = new int[a.length()][b.length()];
        return ediDistance(a, b, a.length() - 1, b.length() - 1, dp);
    }

    private int ediDistance(String a, String b, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) {
            return Math.max(i, j) + 1;
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        boolean charsEqual = a.charAt(i) == b.charAt(j);
        dp[i][j] = min(ediDistance(a, b, i, j - 1, dp) + 1,
                ediDistance(a, b, i - 1, j - 1, dp) + (charsEqual ? 0 : 1),
                ediDistance(a, b, i - 1, j, dp) + 1);
        return dp[i][j];
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    public int dpTopDown(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return Math.max(a.length(), b.length());
        }
        int[][] dp = new int[a.length() + 1][b.length() + 1];
        dp[0][0] = 0;
        for (int i = 1; i <= a.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= b.length(); j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                int tansitionChange = a.charAt(i - 1) == b.charAt(j - 1) ? 0
                        : 1;
                dp[i][j] = min(dp[i - 1][j] + 1, dp[i][j - 1] + 1,
                        dp[i - 1][j - 1] + tansitionChange);
            }
        }
        return dp[a.length()][b.length()];
    }
}
