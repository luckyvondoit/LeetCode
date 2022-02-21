//https://leetcode-cn.com/problems/score-of-parentheses/solution/gua-hao-de-fen-shu-by-leetcode/
package DataStructure.Stack;

import java.util.Stack;

public class _0856_Score_of_Parentheses {
    public int scoreOfParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = s.toCharArray();

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (char c : chars) {
            if (c == '(') {
                stack.push(0);
            } else {
                int m = stack.pop();
                int n = stack.pop();
                stack.push(n + Math.max(2 * m, 1));
            }
        }
        return stack.pop();
    }
}
