/**
 * https://leetcode-cn.com/problems/implement-queue-using-stacks/
 */
package DataStructure.Stack;

import java.util.Stack;

public class _232_用栈实现队列 {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int x) {
        if (stack2.isEmpty()) {
            stack2.push(x);
        } else {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }

            stack1.push(x);

            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public int pop() {
        return empty() ? 0 : stack2.pop();
    }

    public int peek() {
        return empty() ? 0 : stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty();
    }

    public static void main(String[] args) {
        _232_用栈实现队列 obj = new _232_用栈实现队列();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        System.out.println(obj.pop());
        obj.push(5);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());


    }
}
