package Class;
import java.util.Arrays;
public class HouseRobber1 {

    static int dp[] = new int[100005];
    
    /* Time  - O(n)
       Space - O(n)
    */
    public static int f(int nums[], int i) {
        
        if (dp[i] != -1) {
            return dp[i];
        }

        if (i == nums.length - 1) return nums[i];

        if (i == nums.length - 2) {
            return dp[i] = Math.max(nums[i], 0 + f(nums, i + 1));
        } 
        
        return dp[i] = Math.max(nums[i] + f(nums, i + 2), 0 + f(nums, i + 1));
    }

    public static int rob(int[] nums) {
        Arrays.fill(dp, -1);
        return f(nums, 0);
    }

    /* Time  - O(n)
       Space - O(1)
    */
    public static int robIterative(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }

        int next1 = Math.max(nums[n - 2], nums[n - 1]);
        int next2 = nums[n - 1];

        for(int i = n - 3; i >= 0; i--) {
            int curr = Math.max(nums[i] + next2, next1);
            next2 = next1;
            next1 = curr;
        }

        return next1;
    }

    /* Time  - O(n)
       Space - O(n)
    */
    public static int f_bu(int nums[]) {
        int n = nums.length;
        if (n == 1) return nums[0];

        Arrays.fill(dp, -1);
        dp[n - 1] = nums[n - 1];
        dp[n - 2] = Math.max(nums[n - 2], nums[n - 1]);

        for(int i = n - 3; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }

    public static void main(String[] args) {
        int houses[] = {2, 7, 9, 3, 1, 4, 5, 8, 6, 0};
        // System.out.println(rob(houses)); // 23
        // System.out.println(robIterative(houses)); // 23
        System.out.println(f_bu(houses)); // 23
    }
}
