package Algorithm.Sequence;

public class _0151_颠倒字符串中的单词 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return "";
        // 去掉字符串中多余的空格
        char[] chars = s.toCharArray();
        int clen = chars.length;
        int cur = 0;
        boolean preCharSpace = true;
        for (int i = 0; i < clen; i++) {
            if (chars[i] != ' ') {
                preCharSpace = false;
                chars[cur++] = chars[i];
            } else if (!preCharSpace) {
                chars[cur++] = ' ';
                preCharSpace = true;
            }
        }
        // 有效字符长度
        int len = preCharSpace ? cur - 1 : cur;
        if (len <= 0) return "";
        // 翻转整个字符串
        reverse(chars, 0, len);
        // 翻转空格之间的字符串
        int preSpaceIndex = -1;
        for (int i = 0; i < len; i++) {
            if (chars[i] == ' ') {
                reverse(chars, preSpaceIndex + 1, i);
                preSpaceIndex = i;
            }
        }
        // 需要单独对最后一个单词处理。
        reverse(chars, preSpaceIndex + 1, len);

        return new String(chars, 0, len);
    }

    private void reverse(char[] chars, int begin, int end) {
        end--;
        while (begin < end) {
            char tmp = chars[begin];
            chars[begin] = chars[end];
            chars[end] = tmp;
            begin++;
            end--;
        }
    }

    public static void main(String[] args) {
        _0151_颠倒字符串中的单词 obj = new _0151_颠倒字符串中的单词();
        System.out.println(obj.reverseWords("hello world!"));

    }
}
