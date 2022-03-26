package Algorithm.DFS_解决排列组合问题;

import java.util.ArrayList;
import java.util.List;

public class _0017_电话号码的字母组合 {
    private char[][] lettersArray= {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    private char[] chars;
    private char[] string;
    private List<String> list;


    public List<String> letterCombinations(String digits) {
        list = new ArrayList<>();
        if (digits == null) return list;
        chars = digits.toCharArray();
        if (chars.length == 0) return list;
        string = new char[chars.length];
        dfs(0);
        return list;
    }

    private void dfs(int index) {
        if (index == chars.length) {
            list.add(new String(string));
            return;
        }
        char[] letters = lettersArray[chars[index] - '2'];
        for (char letter : letters) {
            string[index] = letter;
            dfs(index + 1);
        }
    }
}
