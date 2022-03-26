package Algorithm.DynamicProgramming;

import java.util.concurrent.RecursiveTask;

public class _0322_零钱兑换 {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount <= 1) return -1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i < coin) continue;
                if (dp[i - coin] < 0 || dp[i - coin] >= min) continue;
                min = dp[i - coin];
            }
            if (min == Integer.MAX_VALUE) {
                dp[i] = -1;
            } else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }

}


