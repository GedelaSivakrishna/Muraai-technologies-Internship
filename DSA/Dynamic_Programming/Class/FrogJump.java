package Class;
import java.util.Arrays;
import java.util.Scanner;
public class FrogJump {

    static int dp[];
    /* Time  - O(n)
       Space - O(n)
    */
    public static int f_td_backward(int i, int heights[]) {
        // base case
        // if frog already on last stone, no need to jump, total energy cost = 0
        if (i == heights.length - 1) return 0;

        // check if minimum energy from i to n already present in dp
        if (dp[i] != -1) {
            return dp[i];
        }

        // frog on last 2nd stone
        if (i == heights.length - 2) {
            return dp[i] = Math.abs(heights[i + 1] - heights[i]);
        }

        return dp[i] = Math.min(Math.abs(heights[i] - heights[i + 2]) + f_td_backward(i + 2, heights), Math.abs(heights[i] - heights[i + 1]) + f_td_backward(i + 1, heights));
    }

    /* Time  - O(n)
       Space - O(n)
    */
    public static int f_td_forward(int i, int heights[]) {
        if (i == 0 || heights.length == 1) return 0;
        if (i == 1 || heights.length == 2) return Math.abs(heights[1] - heights[0]);

        // check if subproblem is already solved
        if (dp[i] != -1) return dp[i];

        return dp[i] = Math.min( f_td_forward(i - 2, heights) + Math.abs(heights[i] - heights[i - 2]), 
                                 f_td_forward(i - 1, heights) + Math.abs(heights[i] - heights[i - 1]) );
    }

    /* Time  - O(n)
       Space - O(n)
    */
    public static int f_bu_backward(int n, int heights[]) {
        if (n == 1) return 0;
        if (n == 2) return Math.abs(heights[0] - heights[1]);

        dp[n - 2] = Math.abs(heights[n - 2] - heights[n - 1]);
        dp[n - 3] = Math.min(Math.abs(heights[n - 3] - heights[n - 1]), Math.abs(heights[n - 3] - heights[n - 2]) + dp[n - 2]);
        for(int i = n - 4; i >= 0; i--) {
            dp[i] = Math.min(Math.abs(heights[i] - heights[i + 2]) + dp[i + 2], Math.abs(heights[i] - heights[i + 1]) + dp[i + 1]);
        }

        return dp[0];
    }

    /* Time  - O(n)
       Space - O(n)
    */
    public static int f_bu_forward(int n, int heights[]) {
        if (n == 1) return 0;
        if (n == 2) return Math.abs(heights[1] - heights[0]);

        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        for(int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 2] + Math.abs(heights[i] - heights[i - 2]), 
                             dp[i - 1] + Math.abs(heights[i] - heights[i - 1]));
        }

        return dp[n - 1];
    }

    public static int frogJump(int n, int heights[]) {
        dp = new int[n];
        Arrays.fill(dp, -1);
        // return f_td_backward(0, heights);
        // return f_bu_backward(n, heights);
        // return f_td_forward(n - 1, heights);
        return f_bu_forward(n, heights);
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int heights[] = new int[n];
        for(int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }
        System.out.println(frogJump(n, heights));
    }
}
