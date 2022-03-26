package DataStructure.String;

public class _0242_有效的字母异位词 {
    public boolean isAnagram(String s, String t) {
        if (s == null || s.length() == 0) return false;
        if (t == null || t.length() == 0) return false;
        if (s.length() != t.length()) return false;

        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();

        int[] sCount = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sCount[schars[i] - 'a']++;
        }

        int[] tCount = new int[26];
        for (int i = 0; i < t.length(); i++) {
            tCount[tchars[i] - 'a']++;
        }

        for (int i = 0; i < sCount.length; i++) {
            if (sCount[i] != tCount[i]) return false;
        }

        return true;
    }
}
