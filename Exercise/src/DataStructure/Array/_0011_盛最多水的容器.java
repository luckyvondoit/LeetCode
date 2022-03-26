package DataStructure.Array;


/**
 * 解题思路：
 * 1。使用两个指针分别从最左和最右向中间移动
 * 2。每次移动尽可能多的次数。
 */
public class _0011_盛最多水的容器 {
    public int maxArea(int[] height) {
        if (height == null || height.length == 0) return 0;
        int li = 0, ri = height.length - 1, water = 0;
        while (li < ri) {
            if (height[li] <= height[ri]) {
                int min = height[li];
                water = Math.max(water, (ri - li) * height[li]);
                while (li < ri && height[li] <= min) li++;
            } else {
                int min = height[ri];
                water = Math.max(water, (ri - li) * height[ri]);
                while (li < ri && height[ri] <= min) ri--;
            }
        }
        return water;
    }
}
