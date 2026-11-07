import java.util.*;
public class EditDistance {
    
    // Time  - O(3^L1+L2) L1, L2 are the length's of the Strings
    // Space - O(L1+L2) callstack depth
    public static int f(String s1, String s2, int i, int j) {
        // base cases
        /* If s1 is empty and to make it equal to s2, we need to insert j characters */
        if (i == 0) return j;
        /* If s2 is empty and to make s1 equal to s2, we need to remove i characters */
        if (j == 0) return i;

        /* If last characters of both String's are equal then find the n.o of operations
           required to make s1[0, i - 1] equal s2[0, j - 1] */
        if (s1.charAt(i) == s2.charAt(j)) return f(s1, s2, i - 1, j - 1);
        else {
            return 1 + Math.min(f(s1, s2, i, j - 1), Math.min(f(s1, s2, i - 1, j - 1), f(s1, s2, i - 1, j)));
        }
    }

    static int dp[][];
    // Time  - O(m * n)
    // Space - O(m * n)
    public static int f_td(String s1, String s2, int i, int j) {
        // base cases
        /* If s1 is empty and to make it equal to s2, we need to insert j characters */
        if (i == 0) return dp[i][j] = j;
        /* If s2 is empty and to make s1 equal to s2, we need to remove i characters */
        if (j == 0) return dp[i][j] = i;

        // check if subproblem already solved
        if (dp[i][j] != -1) return dp[i][j];

        /* If last characters of both String's are equal then find the n.o of operations
           required to make s1[0, i - 1] equal s2[0, j - 1] */
        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = f_td(s1, s2, i - 1, j - 1);
        else {
            return dp[i][j] = 1 + Math.min(f_td(s1, s2, i, j - 1), Math.min(f_td(s1, s2, i - 1, j - 1), f_td(s1, s2, i - 1, j)));
        }
    }

    // Time  - O(m * n)
    // Space - O(m * n)
    public static int f_bu(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        // dp array of size m * n
        dp = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if (i == 0) dp[i][j] = j;
                else if (j == 0) dp[i][j] = i;
                else if (s1.charAt(i) == s2.charAt(j)) dp[i][j] = dp[i-1][j-1];
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j-1], dp[i-1][j]));
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void print() {
        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        int m = word1.length();
        int n = word2.length();
        // adding space to convert String's to 1 based index
        // System.out.println(f(" " + word1, " " + word2, m, n));

        // dp = new int[m + 1][n + 1];
        // for(int i = 0; i <= m; i++) {
        //     for(int j = 0; j <= n; j++) {
        //         dp[i][j] = -1;
        //     }
        // }
            

        // System.out.println(f_td(" " + word1, " " + word2, m, n));
        // print();

        System.out.println(f_bu(" " + word1, " " + word2));

    }
}
