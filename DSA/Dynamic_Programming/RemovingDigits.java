import java.util.*;

public class RemovingDigits {

    static int dp[] = new int[1000006];
    public static int f_td(int n) {
        if (n == 0) return 0;

        if (dp[n] != -1) return dp[n];

        int minSteps = Integer.MAX_VALUE;
        ArrayList<Integer> digits = digitsOfN(n);
        for(int i = 0; i < digits.size(); i++) {
            int ans = 1 + f_td(n - digits.get(i));
            minSteps = Math.min(minSteps, ans);
        }
        return dp[n] = minSteps;
    }

    // Time - O(n) Space - O(n)
    public static int f_bu(int n) {
        if (n <= 9) return 1;

        for(int i = 1; i <= 9; i++)
            dp[i] = 1;

        for(int i = 10; i <= n; i++) {
            int ans = Integer.MAX_VALUE;
            ArrayList<Integer> digits = digitsOfN(i);
            for(int j = 0; j < digits.size(); j++) {
                ans = Math.min(ans, dp[i - digits.get(j)]);
            }
            dp[i] = ans + 1;
        }

        return dp[n];
    }

    // Time - O(n.o of digits in number)
    public static ArrayList<Integer> digitsOfN(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        while(n > 0) {
            int rem = n % 10;
            if (rem != 0)
                digits.add(rem);
            n /= 10;
        }
        return digits;
    }
    
    public static void main(String[] args) {
        // System.out.println(f(27)); // 5
        // System.out.println(f(20)); // 4
        // System.out.println(f(30)); // 6
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Arrays.fill(dp, -1);
        // System.out.println(f_td(n));
        System.out.println(f_bu(n));
        // digitsOfN(n);
    }
}

/*  Notes
    Recursion time complexity - O(d^n), Space complexity - O(n)
    Here, d - max n.o of digits in n
*/
