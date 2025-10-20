public class MinimumInSortedRotated {
    // Time: O(log n)
    //Space: O(1)
    public static int minimumInSortedRotated(int nums[]) {
        // corner case
        if(nums.length == 1) {
            return nums[0];
        }

        int lo = 0, hi = nums.length - 1;
        int n = nums.length;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[lo] < nums[hi]) {
                return nums[lo];
            }
            if(mid != 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            if(mid + 1 < n && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            // Move pointes accordingly by checking if mid lies on upper or lower curve
            if(nums[lo] < nums[mid]) {
                // upper curve
                lo = mid + 1;
            } else {
                // lower curve
                hi = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 3};
        int nums1[] = {4, 5, 6, 7, 1, 3};
        System.out.println(minimumInSortedRotated(nums));
        System.out.println(minimumInSortedRotated(nums1));
    }
}
