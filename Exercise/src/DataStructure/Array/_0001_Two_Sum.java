package DataStructure.Array;

import java.sql.Array;
import java.util.Dictionary;
import java.util.HashMap;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class _0001_Two_Sum {
    public int[] twoSum(int[] nums, int target) {
        return twoSum1(nums, target);
    }

    private int[] twoSum1(int[] nums, int target) {
        if (nums == null || nums.length < 2) return nums;
        int len = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < len; i++) {
            int num = nums[i];

            Integer pre = map.get(target - num);
            if (pre != null) {
                return new int[]{pre, i};
            }

            map.put(num,i);
        }
        return null;
    }
}
