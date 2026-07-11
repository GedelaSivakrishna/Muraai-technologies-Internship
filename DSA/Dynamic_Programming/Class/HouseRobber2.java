package Class;

public class HouseRobber2 {

    /*  Time  - O(n)
        Space - O(1)
    */
    public static int f(int nums[], int si, int li) {
        int prev2 = nums[si];
        int prev1 = Math.max(nums[si], nums[si + 1]);

        for(int i = si + 2; i <= li; i++) {
            int curr = Math.max(nums[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]); 
        return Math.max(f(nums, 0, n - 2), f(nums, 1, n - 1));
    }

    public static void main(String[] args) {
        int nums[] = {2,3,2};
        int nums2[] = {1,2,3,1};
        System.out.println(rob(nums)); // 3
        System.out.println(rob(nums2)); // 4
    }
}