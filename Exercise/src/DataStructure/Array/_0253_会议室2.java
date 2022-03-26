package DataStructure.Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class _0253_会议室2 {
    public int minMettingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        // 按照会议开始时间排序
        Arrays.sort(intervals, (m1, m2) -> m1[0] - m2[0]);

        // 最小堆
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 添加第一个会议的结束时间
        minHeap.add(intervals[0][1]);

        // 堆顶的含义：目前占用的会议中，最早结束时间。
        for (int i = 1; i < intervals.length; i++) {
            // i号会议开始时间 >= 堆顶，如何成立则可以使用之前的会议，不成立，新开会议室
            if (intervals[i][0] >= minHeap.peek()) {
                minHeap.remove();
            }
            minHeap.add(intervals[i][1]);
        }

        return minHeap.size();

    }

    public int minMettingRooms1(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        int[] begins = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            begins[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }

        Arrays.sort(begins);
        Arrays.sort(ends);

        int room = 0, endIndex = 0;
        for (int begin : begins) {
            for (int i = 0; i < ends.length; i++) {
                // 可以重复利用会议室
                if (begin >= ends[i]) {
                    endIndex++;
                } else  {
                    room++;
                }
            }
        }
        return room;

    }


    public static void main(String[] args) {
        int[][] intervals1 = {{0,30},{5,10},{15,20}};
        int[][] intervals2 = {{7,10},{2,4}};
    }
}
