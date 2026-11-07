
import java.util.Scanner;
import java.util.Arrays;
public class DiceCombinations {

    static int dp[];
    static int MOD = 1000000007;
    // Time  - O(n)
    // Space - O(n)
    public static int f(int n) {
        if (n == 0) return 1;

        if (dp[n] != -1) return dp[n];

        int ans = 0;
        for(int i = 1; i <= 6; i++) {
            if (n - i < 0) break;
            ans = (ans % MOD + f(n - i) % MOD) % MOD;
        }

        return dp[n] = ans;
    }

    // Time  - O(n)
    // Space - O(n)
    public static int f_bu(int n) {
        dp[0] = 1;

        for(int i = 1; i <= n; i++) {
            int ans = 0;
            for(int j = 1; j <= 6; j++) {
                if (i - j < 0) break;
                ans = (ans % MOD + dp[i - j] % MOD) % MOD;
            }
            dp[i] = ans;
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[1000006];
        Arrays.fill(dp, -1);
        // System.out.println(f(n));
        System.out.println(f_bu(n));
    }
}
