public class FindFirstAndLastPosition {

    // lower bound: first greater than or equal to target 
    public static int lowerBound(int nums[], int target) {
        if(nums.length > 0 && nums[0] >= target) {
            return 0;
        }
        int ans = nums.length;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] < target) {
                // discard left half
                lo = mid + 1;
            }
            else {
                ans = mid;
                // find better answer in left half
                hi = mid - 1;
            }
        }
        return ans;
    }

    // upper bound: first greater element than target
    public static int upperBound(int nums[], int target) {
        // corner case
        if(nums.length > 0 && nums[0] > target) {
            return 0;
        }

        int ans = nums.length;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] <= target) {
                // discard left half
                lo = mid + 1;
            } else {
                ans = mid;
                // find better answer in left half
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static int[] findFirstAndLastPosition(int nums[], int target) {
        int lb = lowerBound(nums, target);
        if(lb == nums.length || nums[lb] != target) {
            return new int[]{-1, -1};
        } else {
            int ub = upperBound(nums, target);
            return new int[]{lb, ub - 1};
        }
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 3, 5, 8, 8, 8, 10};
        int target = 8;
        int ans[] = findFirstAndLastPosition(nums, target);
        // [4, 6]
        System.out.println( "[" + ans[0] + ", " + ans[1] + "]");
    }
}
