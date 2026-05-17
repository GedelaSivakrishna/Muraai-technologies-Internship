package Class;
import java.util.Arrays;
public class NthFibonacci {

    static int dp[];

    /*  Time  - O(n) At every recursive tree level, at max 2 calls so total 2n calls
        Space - O(n) dp array + call stack
        Approach - Top Down
    */
    public static int f(int n) {
        if(n == 0 || n == 1) return n;

        // check if the subproblem is already computed
        if(dp[n] != -1) return dp[n];

        return dp[n] = f(n - 1) + f(n - 2);
    }

    /*  Time  - O(n) 
        Space - O(n) dp array 
        Approach - Bottom Up
    */
    public static int f_bu(int n) {
        dp = new int[10005];
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        dp = new int[1000000];
        Arrays.fill(dp, -1);
        System.out.println(f(5));
        System.out.println(f(20));
    }
}
