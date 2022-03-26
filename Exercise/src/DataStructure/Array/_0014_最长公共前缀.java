package DataStructure.Array;

public class _0014_最长公共前缀 {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        int len0 = strs[0].length();
        if (len0 == 0) return "";

        int count = strs.length;

        for (int i = 0; i < len0; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < count; j++) {
                if (strs[j].length() < i || strs[0].charAt(i) != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
}
