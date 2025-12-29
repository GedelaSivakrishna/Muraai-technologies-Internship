package Leetcode_Practice;

public class MinimumSizeSubArraySum {

    public static int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 1 && nums[0] >= target) {
            return n;
        }
        int l = 0, r = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        
        while(r < n) {
            sum += nums[r];

            while(sum >= target) {
                ans = Math.min(ans, (r - l) + 1);
                sum -= nums[l];
                l++;
            }

            r++;
        }

        if(ans == Integer.MAX_VALUE) {
            ans = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = {2,3,1,2,4,3};
        int t1 = 7;
        int nums2[] = {1,4,4};
        int t2 = 4;
        int nums3[] = {1,1,1,1,1,1,1,1};
        int t3 = 11;
        // ans 2
        System.out.println(minSubArrayLen(t1, nums1));
        // ans 1
        System.out.println(minSubArrayLen(t2, nums2));
        // ans 0
        System.out.println(minSubArrayLen(t3, nums3));
    }
}