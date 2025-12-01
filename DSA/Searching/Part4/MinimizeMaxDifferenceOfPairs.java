import java.util.Arrays;

public class MinimizeMaxDifferenceOfPairs {

    public static boolean isPairExist(int nums[], int p, int mid) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n;) {
            if(i + 1 < n && Math.abs(nums[i+1] - nums[i]) <= mid) {
                count++;
                i += 2;
            } else {
                i += 1;
            }
            if(count == p) {
                return true;
            }
        }
        return false;
    }

    // Time O(n log(max - min))
    //Space O(1)
    public static int minimizeMaxDifferenceOfPairs(int nums[], int p) {
        if(p == 0) {
            return 0;
        }
        int n = nums.length;
        Arrays.sort(nums);
        int lo = 0, hi = nums[n - 1] - nums[0];
        int ans = -1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(isPairExist(nums, p, mid)) {
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
        int nums[] = {10, 1, 2, 7, 1, 3};
        int p = 2;
        // ans 1
        System.out.println(minimizeMaxDifferenceOfPairs(nums, p));
        int nums2[] = {4, 2, 1, 2};
        int p2 = 1;
        // ans 0    
        System.out.println(minimizeMaxDifferenceOfPairs(nums2, p2));
        int nums3[] = {3,6,8,7,5,4,9,5};
        int p3 = 0;
        // ans 0
        System.out.println(minimizeMaxDifferenceOfPairs(nums3, p3));
    }
}