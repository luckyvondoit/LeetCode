package Algorithm.DynamicProgramming;

public class _0198_打家劫舍 {

    // 递归
    // 从第i位置往前
    // T(n) = T(n - 1) + T(n - 2)
    // 时间复杂度为：O(2^n)
    // 空间复杂度：O(logn)
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return rob(nums, nums.length - 1);
    }

    private int rob(int[] nums, int begin) {
        if (begin == 0) return nums[0];
        if (begin == 1) return Math.max(nums[0], nums[1]);
        // begin位置可以选也可以不选
        int curRob = nums[begin] + rob(nums, begin - 2);
        int nextRob = rob(nums, begin - 1);
        return Math.max(curRob, nextRob);
    }

    /** 记忆化存储
     * 时间复杂度：O(2^n)
     * 空间复杂度
    */

        public int rob1(int[] nums) {
            if (nums == null || nums.length == 0) return 0;
            if (nums.length == 1) return nums[0];
            if (nums.length == 2) return Math.max(nums[0], nums[1]);

            int[] result = new int[nums.length];
            result[0] = nums[0];
            result[1] = Math.max(nums[0], nums[1]);
            return rob1(nums, nums.length - 1, result);
        }

        private int rob1(int[] nums, int begin, int[] result) {
            if (begin == 0) return result[0];
            if (begin == 1) return result[1];

            if (result[begin] == 0) {
                result[begin] = Math.max(nums[begin] + rob1(nums, begin - 2, result), rob1(nums, begin - 1, result));
            }

            return result[begin];
        }

    /**
     * 递推
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] result = new int[nums.length];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            result[i] = Math.max(nums[i] + result[i - 2], result[i - 1]);
        }
        return result[nums.length - 1];
    }

    /**
     * 递推
     */
    public int rob3(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int tmp = second;
            second = Math.max(nums[i] + first, second);
            first = tmp;
        }
        return second;
    }


}
