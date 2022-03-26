package Algorithm.DynamicProgramming;

public class _1143_最长公共子序列 {
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text1.length() ==0 ) return 0;
        if (text2 == null || text2.length() == 0) return 0;
        char[] ch1 = text1.toCharArray();
        char[] ch2 = text2.toCharArray();
        int len1 = ch1.length;
        int len2 = ch2.length;
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <=len2; j++) {
                if (ch1[i - 1] == ch2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
