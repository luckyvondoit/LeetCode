package DataStructure.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _0215_数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        if (len < k) return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        for (int i = 0; i < len; i++) {
            if (i < k) {
                minHeap.add(nums[i]);
            } else {
                int top = minHeap.peek();
                if (nums[i] > top) {
                    minHeap.remove();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(5, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        minHeap.add(5);
        minHeap.add(3);
        minHeap.add(4);
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll());
        }
    }
}
