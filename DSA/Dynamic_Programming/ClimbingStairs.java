
import java.util.Arrays;
public class ClimbingStairs {

    // Time - O(2^n)  Space - O(n)
    public static int f(int n) {
        // base case
        if (n == 1 || n == 2) return n;

        return f(n - 1) + f(n - 2);
    }

    static int dp[];

    // Time - O(n)  Space - O(n)
    public static int f_td(int n) {
        if (n == 1 || n == 2) return n;

        // return ans, if subproblem already solved
        if (dp[n] != -1) return dp[n];

        return dp[n] = f(n - 1) + f(n - 2);
    }

    // Time - O(n)  Space - O(n)
    public static int f_bu(int n) {
        dp = new int[n + 1];
        dp[1] = 1; // 1 way to climb 1 stair
        dp[2] = 2; // 2 ways to climb 2 stairs

        for(int i = 3; i <= n; i++)
            dp[i] = dp[i - 1] + dp[i - 2];

        return dp[n];
    }
    
    public static void main(String[] args) {
        int n = 5;
        // System.out.println(f(n)); // 8
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        // System.out.println(f_td(n)); // 8
        System.out.println(f_td(n)); // 8
    }
}
