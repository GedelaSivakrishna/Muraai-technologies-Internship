import java.util.*;
public class LongestIncreasingSubsequenceLength {

    // Time  - O(n^2) total recursive calls
    // Space - O(n) callstack depth
    public static int f(int nums[], int i) {
        int ans = 1;
        for(int j = 0; j < i; j++) {
            if (nums[j] < nums[i])
                ans = Math.max(ans, f(nums, j) + 1);
        }
        return ans;
    }

    // Time  - O(n^3)
    // Space - O(n)
    public static int lis(int nums[]) {
        int maxLis = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            maxLis = Math.max(maxLis, f_td(nums, i));
        }
        return maxLis;
    }

    static int dp[];
    // Time  - O(n) single loop
    // Space - O(n) dp array
    public static int f_td(int nums[], int i) {
        // check if subproblem already solved
        if (dp[i] != -1) return dp[i];

        int ans = 1;
        for(int j = 0; j < i; j++) {
            if (nums[j] < nums[i])
                ans = Math.max(ans, f_td(nums, j) + 1);
        }
        return dp[i] = ans;
    }

    // Time  - O(n^2) nested loop
    // Space - O(n) dp array 
    public static int f_bu(int nums[]) {
        dp = new int[nums.length];
        // fill base cases
        // at every index, min lis length is 1
        for(int i = 0; i < nums.length; i++)
            dp[i] = 1;

        // find length of longest lis ending at every index
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) 
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
        }

        // find max length lis in nums
        int maxLis = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++) {
            maxLis = Math.max(maxLis, dp[i]);
        }
        return maxLis;
    }

    // Time  - O(logn)
    // Space - O(1)
    public static int lowerBound(ArrayList<Integer> list, int elem) {
        int n = list.size();
        int ans = -1;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (list.get(mid) >= elem) {
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

    // Time  - O(nlogn) loop and binary search
    // Space - O(n) temp list
    public static int lisBinarySearch(int nums[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] > list.getLast()) {
                list.add(nums[i]);
            } else {
                int lb = lowerBound(list, nums[i]);
                list.set(lb, nums[i]);
            }
        }

        // The elements in list doesn't represent the actual LIS elements, only the list size
        // represents the max len LIS. This overwritting technique saves space
        return list.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];

        // i/p nums
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        // dp = new int[n];
        // Arrays.fill(dp, -1);

        // System.out.println(lis(nums));

        // System.out.println(f_bu(nums));

        System.out.println(lisBinarySearch(nums));
    }
}
