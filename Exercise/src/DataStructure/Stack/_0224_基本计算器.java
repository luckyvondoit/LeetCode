/**
 * 题目：https://leetcode-cn.com/problems/basic-calculator/
 * 讲解：https://mp.weixin.qq.com/s?__biz=MzAxODQxMDM0Mw==&mid=2247484903&idx=1&sn=184beaad36a71c9a8dd93c41a8ba74ac&chksm=9bd7fbefaca072f9beccff92a715d92ee90f46c297277eec10c322bc5ccd053460da6afb76c2&scene=21#wechat_redirect
 */
package DataStructure.Stack;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _0224_基本计算器 {

    private boolean[] visited;

    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;

        char[] chars = s.toCharArray();

        List<Character> list = new LinkedList<>();
        for (char c: chars) {
            if (c != ' ') {
                list.add(c);
            }
        }


        Character[] newChar = list.toArray(new Character[list.size()]);

        visited = new boolean[newChar.length];

        return calculate(newChar, 0);
    }

    private int calculate(Character[] chars, int begin) {
        Stack<Integer> stack = new Stack<>();
        int len = chars.length;
        char operation = '+';
        int num = 0;

        for (int i = begin; i < len; i++) {
            char c = chars[i];

            if (visited[i] == true) continue;

            visited[i] = true;

            if (c == '(') {
                num = calculate(chars, i);
            }

            boolean isDigit = Character.isDigit(c);

            if (isDigit) {
                num = num * 10 + Character.getNumericValue(c);
            }

            if (!isDigit || i == len - 1) {
                int prev = 0;
                switch (operation) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        prev = stack.pop();
                        stack.push(prev * num);
                        break;
                    case '/':
                        prev = stack.pop();
                        stack.push(prev / num);
                        break;

                    default:
                        break;
                }

                if (c == ')') {
                    break;
                }

                operation = c;
                num = 0;
            }
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        _0224_基本计算器 obj = new _0224_基本计算器();
        System.out.println(obj.calculate("2-1 + 2 "));
    }
}
