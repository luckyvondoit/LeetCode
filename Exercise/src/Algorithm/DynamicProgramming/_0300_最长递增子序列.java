package Algorithm.DynamicProgramming;

public class _0300_最长递增子序列 {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < len; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) continue;
                dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
