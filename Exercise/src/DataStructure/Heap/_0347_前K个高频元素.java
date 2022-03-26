package DataStructure.Heap;

import java.util.*;
import java.util.Map.Entry;

public class _0347_前K个高频元素 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>((Integer i1, Integer i2) -> map.get(i1) - map.get(i2));
        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            } else if (queue.size() == k && entry.getValue() > map.get(queue.peek())) {
                queue.poll();
                queue.offer(entry.getKey());
            }
        }

        List<Integer> list = new LinkedList<>();
        while (!queue.isEmpty()) {
            list.add(0, queue.poll());
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
