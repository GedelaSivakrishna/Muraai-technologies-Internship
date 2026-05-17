package Class;
import java.util.Arrays;
public class HouseRobber1 {

    static int dp[] = new int[100005];
    
    public static int f(int nums[], int i) {
        if (i == nums.length - 1) return nums[i];

        if (i >= nums.length) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }
        
        return dp[i] = Math.max(nums[i] + f(nums, i + 2), 0 + f(nums, i + 1));
    } 

    public static int rob(int[] nums) {
        Arrays.fill(dp, -1);
        return f(nums, 0);
    }

    public static void main(String[] args) {
        int houses[] = {2,7,9,3,1};
        System.out.println(rob(houses)); // 12
    }
}
