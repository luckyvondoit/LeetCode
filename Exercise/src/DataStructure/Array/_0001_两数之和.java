package DataStructure.Array;

import java.util.HashMap;

public class _0001_两数之和 {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(target - nums[i]);
            if (index != null) return new int[]{index, i};
            map.put(nums[i], i);
        }
        return nums;
    }
}
