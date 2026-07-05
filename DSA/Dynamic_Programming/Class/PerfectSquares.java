package Class;

import java.util.Arrays;

public class PerfectSquares {
    
    public int squares[];
    public int dp[];

    // Time  - O(n * m) m -> squares.length
    // Space - O(n) dp space + call stack
    public int f(int n) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < squares.length; i++) {
            if (squares[i] <= n) {
                ans = Math.min(ans, f(n - squares[i]));
            } else {
                // we cannot form n with a perfect square
                // integer whose value is > n
                break;
            }
        }

        return dp[n] = 1 + ans;
    }

    // Time  - O(n * m) m -> squares.length
    // Space - O(n) dp space
    public int f_bu(int n) {
        dp[0] = 0; // zero squares required to sum upto 0

        for(int i = 1; i <= n; i++) {
            int ans = Integer.MAX_VALUE;
            for(int j = 0; j < squares.length; j++) {
                if (squares[j] <= i) {
                    ans = Math.min(ans, dp[i - squares[j]]);
                } else {
                    // we cannot form n with a perfect square
                    // integer whose value is > n
                    break;
                }
            }
            dp[i] = 1 + ans;
        }

        return dp[n];
    }

    public int numSquares(int n) {
        squares = new int[100];
        // fill the squares
        int j = 0;
        for(int i = 1; i * i <= 10000; i++) {
            squares[j++] = i * i;
        }
        dp = new int[10004];
        Arrays.fill(dp, -1);
        // return f(n);
        return f_bu(n);
    }

}
