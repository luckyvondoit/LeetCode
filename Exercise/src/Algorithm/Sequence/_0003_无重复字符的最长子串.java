package Algorithm.Sequence;

import java.util.HashMap;

public class _0003_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();

        // 用来保存每一个字符上一次出现的位置
        HashMap<Character, Integer> prevIndexs = new HashMap<>();
        prevIndexs.put(chars[0], 0);
        // 以i - 1位置字符结尾的最长不重复字符串的开始索引
        int li = 0;
        int max = 1;
        for (int i = 1; i < chars.length; i++) {
            // i位置字符上一次出现的位置
            int pi = prevIndexs.getOrDefault(chars[i], -1);
            if (li <= pi) {
                li = pi + 1;
            }
            // 存储这个字符出现的位置
            prevIndexs.put(chars[i], i);
            max = Math.max(max, i - li + 1);
        }
        return max;
    }
}
