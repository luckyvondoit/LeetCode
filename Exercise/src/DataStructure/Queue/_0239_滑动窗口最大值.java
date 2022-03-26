package DataStructure.Queue;

import java.util.Deque;
import java.util.LinkedList;


public class _0239_滑动窗口最大值 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;

        int[] maxArray = new int[nums.length - k + 1];

        int maxIdx = 0;
        for (int i = 1; i < k; i++) {
            if (nums[i] >= nums[maxIdx]) maxIdx = i;
        }

        // i 是滑动窗口的最左端
        for (int i = 0; i < maxArray.length; i++) {
            // ri是滑动窗口的最右端
            int ri = i + k - 1;
            if (maxIdx < i) {
                maxIdx = i;
                for (int j = i + 1; j <= ri; j++) {
                    if (nums[j] >= nums[maxIdx]) maxIdx = j;
                }
            } else {
                if (nums[ri] >= nums[maxIdx]) {
                    maxIdx = ri;
                }
            }
            maxArray[i] = nums[maxIdx];
        }

        return maxArray;
    }


    /**
     * 解题思路：需要使用双端队列存放当前扫描元素中最大值的下标（单调队列，单调递增，单调递减）。
     * 1.如果nums[i] >= nums[queue.peekLast()],不断删除队列末尾元素，直到nums[i] < nums[queue.peekLast()]
     * 2.将nums[i]加入队尾
     * 3.如果w >= 0 (i是nums的下标，同时也是滑块末尾元素的下标，li是滑块开头元素的下标，所有li = i - k + 1)
     *   1>如果队头失效，就移除队头元素（队头元素（存放的是元素的下标） < w就代表失效）
     *   2>设置滑动窗口最大值为nums[queue.peekFirst()]
     */
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 1) return new int[0];
        if (k == 1) return nums;

        int[] maxArray = new int[nums.length - k + 1];
        Deque<Integer> queue = new LinkedList<>();

        // i和滑动窗口最右端元素下标相同
        for (int i = 0; i < nums.length; i++) {
            while (!queue.isEmpty() && nums[queue.peekLast()] <= nums[i]) {
                queue.pollLast();
            }

            queue.offerLast(i);
            int li = i - k + 1;
            if (li < 0) continue;

            if (queue.peekFirst() < li) {
                queue.pollFirst();
            }

            maxArray[li] = nums[queue.peekFirst()];

        }
        return maxArray;
    }
}
