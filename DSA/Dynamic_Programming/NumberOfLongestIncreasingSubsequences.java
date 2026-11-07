import java.util.*;
public class NumberOfLongestIncreasingSubsequences {

    public static int lowerBound(int nums[], int elem) {
        int n = nums.length;
        int ans = -1;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] >= elem) {
                // possible candidate for ans
                ans = mid;
                // find better ans to left
                hi = mid - 1;
            } else {
                // discard left, ans lies in right
                lo = mid + 1;
            }
        }

        return ans;
    }

    public static int f_bu(int nums[]) {
        int n = nums.length;
        int dp[] = new int[n];

        // fill base cases, set dp[i] = 1 for all elements
        for(int i = 0; i < n; i++)
            dp[i] = 1;

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        Arrays.sort(dp);
        int lb = lowerBound(nums, dp[n - 1]);
        return n - lb;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];

        // i/p nums
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        System.out.println(f_bu(nums));
    }
}
