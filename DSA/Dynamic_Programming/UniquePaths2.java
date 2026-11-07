import java.util.*;
public class UniquePaths2 {
    
    // Time  - O(2^m+n) every step 2 calls, max depth = rows + cols
    // Space - O(m+n) call stack depth
    public static int f(int row, int col, int grid[][], int m, int n) {
        // If we reach end cell, we found one path
        if (row == m - 1 && col == n - 1) return 1;

        // If we go out of boundary or encountered an obstacle, no path can be found
        if (row == m || col == n || grid[row][col] == 1) return 0;

        // total ways to reach grid[m - 1][n - 1]
        return f(row, col + 1, grid, m, n) + f(row + 1, col, grid, m, n);
    }

    static int dp[][];
    // Time  - O(m * n) every state is calculated once, total recursive calls = m * n
    // Space - O(m * n) space taken by dp array
    public static int f_td(int row, int col, int grid[][], int m, int n) {
        // If we reach end cell, we found one path
        if (row == m - 1 && col == n - 1) return 1;

        // If we go out of boundary or encountered an obstacle, no path can be found
        if (row == m || col == n || grid[row][col] == 1) return 0;

        // check if subproblem already solved
        if (dp[row][col] != -1) return dp[row][col];

        // total ways to reach grid[m - 1][n - 1]
        return dp[row][col] = f(row, col + 1, grid, m, n) + f(row + 1, col, grid, m, n);
    }

    // Time  - O(m * n) traversing the grid
    // Space - O(m * n) space taken by dp array
    public static int f_bu(int grid[][]) {
        int m = grid.length;
        int n = grid[0].length;
        // total ways to reach from grid[m - 1][n - 1] to grid[m - 1][n - 1] is 1
        // don't make any move, stay there
        dp[m - 1][n - 1] = 1;

        // calculate total ways to reach grid[m - 1][n - 1] from other cells
        for(int row = m - 1; row >= 0; row--) {
            for(int col = n - 1; col >= 0; col--) {
                // If cell is obstacle, total ways = 0
                if (grid[row][col] == 1) continue;

                if (row == m - 1 && col == n - 1) continue;

                // right ways
                int right = col + 1 < n ? dp[row][col + 1] : 0;
                // down ways
                int down = row + 1 < m ? dp[row + 1][col] : 0;

                // total ways to reach grid[m - 1][n - 1] from grid[row][col]
                dp[row][col] = right + down;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int grid[][] = new int[m][n];

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        }

        // System.out.println(f(0, 0, grid, m, n));

        dp = new int[m][n];
        // for(int i = 0; i < m; i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // System.out.println(f_td(0, 0, grid, m, n));

        System.out.println(f_bu(grid));
    }
}
