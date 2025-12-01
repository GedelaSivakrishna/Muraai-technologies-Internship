public class MinimizedMaximumSubArraysSum {

    public static boolean canSplitArrayToKSubArraysWithMaxSumAtmostMid(int nums[], int k, int mid) {
        int pairs = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            if(sum + nums[i] > mid) {
                pairs++;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
        }

        // if we can split the array to < k pairs by keeping the subArray sum atleast mid then
        // we can definitely split it into k pairs.
        /* Exp: nums = {1,2,3,4,5}, mid = 8
         *      {1,2,3}, {4}, {5} 
         *      The above are the minimum possible split of array into subarrays by keeping subArray sum <= mid.
         *      We can also split into more subArrays, It's even easier.
         *      {1}, {2}, {3}, {4}, {5}
         */
        return pairs <= k;
    }

    // Time O(n log(sum - min))
    //Space O(1)
    public static int splitArray(int[] nums, int k) {
        int n = nums.length;
        int max = 0, sum = 0;
        for(int elem : nums){
            max = Math.max(elem, max);
            sum += elem;
        }
        if(n == 1) {
            return sum;
        }
        int lo = max, hi = sum;
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(canSplitArrayToKSubArraysWithMaxSumAtmostMid(nums, k, mid)) {
                // found potential answer
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {7,2,5,10,8};
        int k = 2;
        // ans 18
        System.out.println(splitArray(nums, k));
    }
}