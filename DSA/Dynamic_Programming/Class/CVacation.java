package Class;
import java.util.Scanner;
public class CVacation {

    static int dp[][];
    /* Time  - O(n)
       Space - O(n)
    */
    public static int f_bu(int[][] arr, int n) {
       dp = new int[n][3];
       // base cases
       dp[n - 1][0] = arr[n - 1][0];
       dp[n - 1][1] = arr[n - 1][1];
       dp[n - 1][2] = arr[n - 1][2];

       for(int i = n - 2; i >= 0; i--) {
        dp[i][0] = arr[i][0] + Math.max(dp[i + 1][1], dp[i + 1][2]);
        dp[i][1] = arr[i][1] + Math.max(dp[i + 1][0], dp[i + 1][2]);
        dp[i][2] = arr[i][2] + Math.max(dp[i + 1][0], dp[i + 1][1]);
       }

       return Math.max(dp[0][0], Math.max(dp[0][1], dp[0][2]));
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[][] = new int[n][3];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < 3; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(f_bu(arr, n));
    }
}
