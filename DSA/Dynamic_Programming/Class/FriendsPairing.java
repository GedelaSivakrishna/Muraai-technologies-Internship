package Class;

import java.util.Arrays;

public class FriendsPairing {
    
    public static long dp[] = new long[100000];
    static long mod = 1000000007;
    /* Time - O(n), Space - O(n) */
    public static long f(int n) {
        // when there are zero friends, zero ways to pair them
        if(n == 0 || n == 1 || n == 2) return n;
       
        // check in dp
        if(dp[n] != -1) return dp[n];
        long singleWays = f(n - 1) % mod;
        long pairWays = ((n - 1) % mod * f(n - 2) % mod) % mod;
        return dp[n] = (singleWays % mod + pairWays % mod) % mod;
    }

    public static void numberOfWays(int n) {
        // fill dp with -1
        Arrays.fill(dp, -1);
        System.out.println(f(n));
    }

    public static void main(String[] args) {
        numberOfWays(37);
    }
}
