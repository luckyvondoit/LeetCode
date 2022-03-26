/**
 * https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/
 */
package Algorithm.Josephus;

import java.awt.*;
import java.util.LinkedList;

// f(n, m) = (f(n-1, m) + m) % n
public class _剑指Offer_62_圆圈中最后剩下的数字 {
    public int lastRemaining(int n, int m) {
        int index = 0;
        for (int i = 2; i <= n; i++) {
            index = (index + m) % i;
        }
        return index;
    }

    public int lastRemaining1(int n, int m) {
        if (n == 1) return 0;
        return (lastRemaining1(n - 1, m) + m) % n;
    }
}
