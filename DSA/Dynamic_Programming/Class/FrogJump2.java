package Class;
import java.util.Scanner;
import java.util.Arrays;
public class FrogJump2 {

    static int dp[];

    /* Time  - O(n)
       Space - O(n)
    */
    // f(i) -> denotes minimum cost required from i to n 
    public static int f_td_backward(int i, int k, int heights[]) {
        if (i == heights.length - 1) return 0;

        // check if subproblem already solved
        if (dp[i] != -1) return dp[i];

        int minCost = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++) {
            if (i + j >= heights.length) continue;
            minCost = Math.min(minCost, f_td_backward(i + j, k, heights) + Math.abs(heights[i + j] - heights[i]));
        }

        // store the minCost from i to n
        dp[i] = minCost;

        return minCost;
    }

    /* Time  - O(n)
       Space - O(n)
    */
    // f(i) -> denotes the minimum cost required from 0 to i
    public static int f_td_forward(int i, int k, int heights[]) {
        if (i == 0) return 0;

        // check if subproblem already solved
        if (dp[i] != -1) return dp[i];

        int minCost = Integer.MAX_VALUE;
        for(int j = 1; j <= k; j++) {
            if (i - j < 0) continue;
            minCost = Math.min(minCost, f_td_forward(i - j, k, heights) + Math.abs(heights[i] - heights[i - j]));
        }

        // store the minCost from 0 to i
        dp[i] = minCost;

        return minCost;
    }
    
    /* Time  - O(n)
       Space - O(n)
    */
    // dp[i] represents the minimum cost from i to n
    public static int f_bu_backward(int k, int heights[]) {
        int n = heights.length;
        dp = new int[n];
        dp[n - 1] = 0;

        for(int i = n - 2; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            for(int j = 1; j <= k; j++) {
                if (i + j >= n) break;
                minCost = Math.min(minCost, Math.abs(heights[i + j] - heights[i]) + dp[i + j]);
            }
            dp[i] = minCost;
        }

        return dp[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int heights[] = new int[n];
        // i/p heights
        for(int i = 0; i < n; i++)
            heights[i] = sc.nextInt();
        dp = new int[n];
        Arrays.fill(dp, -1);
        // System.out.println(f_td_backward(0, k, heights));
        // System.out.println(f_td_forward(n - 1, k, heights));
        // System.out.println(f_bu_backward(k, heights));
    }
}
