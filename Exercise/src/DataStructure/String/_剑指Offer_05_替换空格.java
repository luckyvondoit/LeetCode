package DataStructure.String;

public class _剑指Offer_05_替换空格 {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) return "";

        int length = s.length();
        char[] array = new char[length * 3];
        int count = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[count++] = '%';
                array[count++] = '2';
                array[count++] = '0';
            } else {
                array[count++] = c;
            }
        }
        return new String(array, 0, count);
    }
}
