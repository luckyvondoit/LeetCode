/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
package DataStructure.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class _0020_有效的括号 {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put('}', '{');
        map.put(']', '[');
        map.put(')', '(');

        Stack<Character> stack = new Stack<>();

        char[] chars = s.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (map.values().contains(chars[i])) {
                stack.push(chars[i]);
            } else {
                if (stack.isEmpty()) return false;

                char c = map.get(chars[i]);
                char top = stack.peek();

                if (c == top) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
