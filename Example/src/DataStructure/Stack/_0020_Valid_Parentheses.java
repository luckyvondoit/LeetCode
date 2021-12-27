package DataStructure.Stack;

import java.util.HashMap;
import java.util.Stack;

public class _0020_Valid_Parentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return false;
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put('}', '{');
        hashMap.put(')', '(');
        hashMap.put(']', '[');

        int len = chars.length;
        for (int i = 0; i < len; i++) {
            char c = chars[i];
            if (hashMap.containsValue(c)) {
                stack.push(c);
            } else {
                if (!stack.isEmpty() && stack.peek() == hashMap.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }

            }
        }
        return stack.isEmpty();
    }
}
