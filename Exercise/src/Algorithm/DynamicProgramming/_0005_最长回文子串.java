package Algorithm.DynamicProgramming;

public class _0005_最长回文子串 {
    // 动态规划法
    public String longestPalindrome1(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        int len = cs.length;
        if (len == 0) return s;

        // dp表示从下标i到j的字符串是否是回文字符串(j >= i)。
        boolean[][] dp = new boolean[len][len];
        // 最长回文子串的长度
        int maxLen = 1;
        // 最长回文子串的开始索引
        int begin = 0;
        // 需要根据dp[i+1][j-1]推导dp[i][j]
        // 所以循环顺序是从下到上，从左到右,
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                // 1、如果s[i,j]的长度 <= 2; dp[i][j] = s[i] == s[j]
                // 2、如果s[i,j]的长度 > 2; dp[i][j] = dp[i+1][j-1] && s[i] == s[j]
                int subLen = j - i + 1;
                dp[i][j] = (cs[i] == cs[j]) && (len <= 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && subLen > maxLen) {
                    maxLen = subLen;
                    begin = i;
                }
            }
        }
        return new String(cs, begin, maxLen);
    }

    // 中心扩展法
    public String longestPalindrome2(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        int maxLen = 1;
        int begin = 0;
        for (int i = cs.length - 2; i >= 1; i--) {
            int len1 = palindromeLength(cs, i - 1, i + 1);
            int len2 = palindromeLength(cs, i, i + 1);
            int curMaxLen = Math.max(len1, len2);
            if (curMaxLen > maxLen) {
                maxLen = curMaxLen;
                begin = i - (maxLen - 1) / 2;
            }
        }
        if (cs[0] == cs[1] && maxLen < 2) {
            maxLen = 2;
            begin = 0;
        }

        return new String(cs, begin, maxLen);

    }

    private int palindromeLength(char[] cs, int li, int ri) {
        while (li >= 0 && ri < cs.length && cs[li] == cs[ri]) {
            li--;
            ri++;
        }
        return ri - li - 1;
    }

    // 中心扩展法优化
    public String longestPalindrome3(String s) {
        if (s == null) return null;
        char[] cs = s.toCharArray();
        if (cs.length <= 1) return s;
        int maxLen = 1;
        int begin = 0;
        int i = 0;
        while (i < cs.length) {
            int li = i - 1;
            int ri = i + 1;
            while (ri < cs.length && cs[i] == cs[ri]) {
                ri++;
            }
            i = ri;
            while (li >= 0 && ri < cs.length && cs[li] == cs[ri]) {
                li--;
                ri++;
            }
            int b = li + 1;
            int len = ri - b;
            if (len > maxLen) {
                maxLen = len;
                begin = b;
            }
        }
        return new String(cs, begin, maxLen);
    }


    private char[] preprocess(char[] oldCs) {
        char[] cs = new char[oldCs.length * 2 + 3];
        cs[0] = '^';
        cs[1] = '#';
        cs[cs.length - 1] = '$';
        for (int i = 0; i < oldCs.length; i++) {
            int idx = (i + 1) * 2;
            cs[idx] = oldCs[i];
            cs[idx + 1] = '#';
        }
        return cs;
    }
}
