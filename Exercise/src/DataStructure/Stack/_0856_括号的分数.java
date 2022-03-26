package DataStructure.Stack;

import java.util.Stack;

public class _0856_括号的分数 {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(0);
            } else {
                int x = stack.pop();
                int y = stack.pop();
                stack.push(y + Math.max(x * 2, 1));
            }
        }
        return stack.pop();
    }
}
