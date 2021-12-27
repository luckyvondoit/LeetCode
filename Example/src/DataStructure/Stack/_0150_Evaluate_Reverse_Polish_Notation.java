package DataStructure.Stack;

import java.util.ArrayList;
import java.util.Stack;

public class _0150_Evaluate_Reverse_Polish_Notation {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        ArrayList<String> operators = new ArrayList<>();
        operators.add("+");
        operators.add("-");
        operators.add("*");
        operators.add("/");

        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (operators.contains(s)) {
                int m = stack.pop();
                int n = stack.pop();
                int res = switch (s) {
                    case "+" -> m + n;
                    case "-" -> n - m;
                    case "*" -> m * n;
                    case "/" -> n / m;
                    default -> 0;
                };
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
