import java.util.*;
public class UniquePaths {

    public static int f(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;

        return f(i + 1, j, m, n) + f(i, j + 1, m, n);
    }

    static int dp[][];
    public static int f_td(int i, int j, int m, int n) {
        if (i == m - 1 && j == n - 1) return 1;
        if (i >= m || j >= n) return 0;

        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = f_td(i + 1, j, m, n) + f_td(i, j + 1, m, n);
    }

    // Time  - O(m * n) -> nested loops
    // Space - O(m * n) -> 2D dp array 
    public static int f_bu(int m, int n) {
        dp = new int[m][n];
        dp[m-1][n-1] = 1;

        // calculate unique ways for each cell
        for(int row = m - 1; row >= 0; row--) {
            for(int col = n - 1; col >= 0; col--) {
                if (row == m - 1 && col == n - 1) continue;
                int right = col + 1 < n ? dp[row][col + 1] : 0;
                int bottom = row + 1 < m ? dp[row + 1][col] : 0;
                dp[row][col] = right + bottom;
            }
        }
        return dp[0][0];
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        // dp = new int[m][n];
        // for(int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // System.out.println(f_td(0, 0, m, n));
        System.out.println(f_bu(m, n));
    }
}
