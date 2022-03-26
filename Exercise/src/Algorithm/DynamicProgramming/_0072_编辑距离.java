package Algorithm.DynamicProgramming;

public class _0072_编辑距离 {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) return 0;
        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();
        int len1 = cs1.length;
        int len2 = cs2.length;
        if (len1 == 0 || len2 == 0) return 0;

        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        // 第0列
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        // 第0行
        for (int j = 1; j<= len2; j++) {
            dp[0][j] = j;
        }
        // 其它元素
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j<= len2; j++) {
                int top = dp[i - 1][j] + 1;
                int left = dp[i][j - 1] + 1;
                int topLeft = dp[i - 1][j - 1];
                if (cs1[i - 1] != cs2[j - 1]) {
                    topLeft++;
                }
                dp[i][j] = Math.min(Math.min(top, left), topLeft);
            }
        }

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        _0072_编辑距离 obj = new _0072_编辑距离();
        obj.minDistance(s1, s2);
    }
}
