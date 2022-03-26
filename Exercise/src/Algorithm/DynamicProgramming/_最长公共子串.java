package Algorithm.DynamicProgramming;

public class _最长公共子串 {
    public int lcs(String s1, String s2) {
        if (s1 == null || s2 == null) return 0;
        int len1 = s1.length();
        int len2 = s2.length();
        if (len1 == 0 || len2 == 0) return 0;

        int max = 0;
        int dp[][] = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max;
    }
}
