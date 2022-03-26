/**
 * 155. 最小栈
 * https://leetcode-cn.com/problems/min-stack/
 */
package DataStructure.Stack;

import java.util.Stack;

public class MinStack {
    /** 用来存放栈数据 */
    private Stack<Integer> stack;
    /** stack每存放一个元素，就将stack当前最小值存放在minStack中 */
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
       return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}
