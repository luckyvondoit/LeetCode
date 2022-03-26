package DataStructure.Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0150_逆波兰表达式求值 {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        List<String> operation = new ArrayList<>();
        operation.add("+");
        operation.add("-");
        operation.add("*");
        operation.add("/");

        Stack<Integer> stack = new Stack<>();

        int len = tokens.length;
        for (int i = 0; i < len; i++) {
            String s = tokens[i];
            if (operation.contains(s)) {
                int y = stack.pop();
                int x = stack.pop();
                int result;
                switch (s) {
                    case "+":
                        result = x + y;
                        break;
                    case "-":
                        result = x - y;
                        break;
                    case "*":
                        result = x * y;
                        break;
                    case "/":
                        result = x / y ;
                        break;
                    default:
                        result = 0;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        String[] tokens = {"2","1","+","3","*"};

        _0150_逆波兰表达式求值 obj = new _0150_逆波兰表达式求值();
        System.out.println(obj.evalRPN(tokens));
    }
}
