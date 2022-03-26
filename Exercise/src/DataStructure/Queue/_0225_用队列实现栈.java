package DataStructure.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class _0225_用队列实现栈 {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }

        Queue<Integer> tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;

    }

    public int pop() {
        if (!queue1.isEmpty()) {
            return queue1.poll();
        }
        return 0;
    }

    public int top() {
        if (!queue1.isEmpty()) {
            return queue1.peek();
        }
        return 0;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

}
