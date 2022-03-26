package DataStructure.Stack;

import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，
 * 其中 answer[i] 是指在第 i 天之后，才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 实例
 * 输入: temperatures = [73,74,75,71,69,72,76,73]
 * 输出: [1,1,4,2,1,1,0,0]
 */

public class _0739_每日温度 {
    public int[] dailyTemperatures(int[] temperatures) {
        if (temperatures == null || temperatures.length == 0) return null;
        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                result[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }
        return result;
    }

    /**
     * 倒推法
     *
     * i用来描述元素，从右往左扫描（i逐渐递减），一开始i指向倒数第二个元素。
     * 对于每一个i，一开始令j = i + 1
     * 1.如果T[i] < T[j],那么value[i] = j - i，然后i--
     * 2.如果T[i] == T[j]
     *  1>如果value[j] == 0, value[i] = 0, 然后i--
     *  2>如果value[j] != 0, value[i] = value[j] + j - i,然后i--
     * 3.如果T[i] > T[j]
     *  1>如果value[j] == 0, value[i] == 0,然后i--
     *  2>如果value[j] != 0, j = j + value[j],从新进入1进行判断
     * */

    public int[] dailyTemperatures1(int[] T) {
        if (T == null || T.length == 0) return null;
        int[] value = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (true) {
                if (T[i] < T[j]) {
                    value[i] = j - i;
                    break;
                } else if (value[j] == 0) {
                    value[i] = 0;
                    break;
                } else if (T[i] == T[j]) {
                   value[i] = value[j] + j - i;
                   break;
                } else {
                    j = j + value[j];
                }
            }
        }
        return value;
    }
}
