package Class;

import java.util.Arrays;

public class CoinsChange {
    
    public int c[]; // global coins array
    public int dp[];

    // Time  - O(n * m) n -> amount, m -> coins array length
    // Space - O(n) dp array + call stack
    public int f(int amount) {
        if (amount < 0) // not possible
            return Integer.MAX_VALUE;

        if (amount == 0) // zero amount, 0 coins reqd
            return 0;

        // if subproblem already calculated, return from dp
        if (dp[amount] != -1)
            return dp[amount];

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < c.length; i++) {
            if (c[i] <= amount) {
                ans = Math.min(ans, f(amount - c[i]));
            }
        }

        // not possible to make amount with the
        // given coins
        if (ans == Integer.MAX_VALUE)
            return dp[amount] = Integer.MAX_VALUE;

        return dp[amount] = 1 + ans;
    }

    // Time  - O(n * m) n -> amount, m -> coins array length
    // Space - O(n) dp space
    public int f_bu(int amount) {
        if (amount == 0) return 0;

        // store base cases in dp
        for(int i = 0; i < c.length; i++) {
            if (c[i] <= amount)
                dp[c[i]] = 1;
        }
            

        for(int j = 1; j <= amount; j++) {
            if (dp[j] != -1) continue;
            int ans = Integer.MAX_VALUE;
            for(int k = 0; k < c.length; k++) {
                if (c[k] <= j) {
                    ans = Math.min(ans, dp[j - c[k]]);
                }
            }
            dp[j] = ans == Integer.MAX_VALUE ? Integer.MAX_VALUE : ans + 1;
        }

        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        c = coins;
        dp = new int[10005];
        Arrays.fill(dp, -1);
        // int ans = f(amount);
        int ans = f_bu(amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
}
