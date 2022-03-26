package Algorithm.DivideAndConquer;

public class _0053_最大子数组和 {
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        return maxSubArray(0, nums.length, nums);

    }

    private int maxSubArray(int begin, int end, int[] nums) {
        if (end - begin < 2) return nums[begin];
        int mid = (begin + end) / 2;
        int leftMax = nums[mid - 1];
        int leftSum = leftMax;
        for (int i = mid - 2; i >= begin; i--) {
           leftSum += nums[i];
           leftMax = Math.max(leftMax, leftSum);
        }
        int rightMax = nums[mid];
        int rightSum = rightMax;
        for (int i = mid + 1; i < end; i++) {
            rightSum += nums[i];
            rightMax = Math.max(rightSum, rightMax);
        }
        return Math.max(leftMax + rightMax, Math.max(maxSubArray(begin, mid, nums), maxSubArray(mid, end, nums)));
    }
}
