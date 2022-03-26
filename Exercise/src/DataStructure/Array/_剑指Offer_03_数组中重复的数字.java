package DataStructure.Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class _剑指Offer_03_数组中重复的数字 {
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            int tmp = map.getOrDefault(num, 0);
            if (tmp == 0) {
                map.put(num, ++tmp);
            } else {
                return num;
            }
        }
        return 0;
    }

    public int findRepeatNumber1(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        int repeat = -1;
        for (int num : nums) {
            if (!set.add(num)) {
                repeat = num;
                break;
            }
        }
        return repeat;
    }
}
