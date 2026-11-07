import java.util.*;
public class Triangle {
    // Time  - O(2^n) exploring all possible paths
    // Space - O(n) callstack depth
    public static int f(int i, int j, List<List<Integer>> t) {
        // if we are on last row then min sum to reach last row is t[i][j]
        if (i == t.size() - 1) return t.get(i).get(j);

        return t.get(i).get(j) + Math.min(f(i + 1, j, t), f(i + 1, j + 1, t));
    }

    static int dp[][];
    // Time  - O(n^2) every state in dp array calculated once
    // Space - O(n^2) dp array
    public static int f_td(int i, int j, List<List<Integer>> t) {
        // if we are on last row then min sum to reach last row is t[i][j]
        if (i == t.size() - 1) return dp[i][j] = t.get(i).get(j);

        // check if subproblem already solved
        if (dp[i][j] != -1) return dp[i][j];

        return dp[i][j] = t.get(i).get(j) + Math.min(f_td(i + 1, j, t), f_td(i + 1, j + 1, t));
    }

    // Time  - O(n^2) nested loops
    // Space - O(n^2) dp array
    public static int f_bu(List<List<Integer>> t) {
        int n = t.size();
        dp = new int[n][n];

        // fill base cases
        for(int i = 0; i < n; i++)
            dp[n - 1][i] = t.get(n - 1).get(i);

        for(int i = n - 2; i >= 0; i--) {
            for(int j = 0; j <= i; j++)
                dp[i][j] = t.get(i).get(j) + Math.min(dp[i + 1][j], dp[i + 1][j + 1]);
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> triangle = new ArrayList<>();
        // i/p triangle
        for(int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i; j++)
                list.add(sc.nextInt());
            triangle.add(list);
        }

        // System.out.println(f(0, 0, triangle));
        System.out.println(f_bu(triangle));
    }
}
