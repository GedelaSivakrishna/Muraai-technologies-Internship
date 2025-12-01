public class SearchInRotatedSortedArray2 {

    public static boolean searchInRotatedSortedArray2(int nums[], int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                lo++;
                hi--;
                continue;
            }
            // upper curve
            if(nums[mid] > nums[lo]) {
                if(nums[lo] <= target && target <= nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                // lower curve
                if(nums[mid] <= target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int nums1[] = {1,0,1,1,1};
        int target1 = 0;
        int nums2[] = {1,1,1,0,1};
        int target2 = 10;
        System.out.println(searchInRotatedSortedArray2(nums1, target1));
        System.out.println(searchInRotatedSortedArray2(nums2, target2));
    }
}