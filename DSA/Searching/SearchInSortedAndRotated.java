public class SearchInSortedAndRotated {
    // Time: O(log n)
    //Space: O(1)
    public static int searchInSortedAndRotated(int nums[], int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == target) {
                return mid;
            }

            // check if we are on upper or lower curve
            if(nums[lo] <= nums[mid]) {
                // upper curve
                if(target >= nums[lo] && target <= nums[mid]) {
                    // discard right
                    hi = mid - 1;
                } else {
                    // discard left
                    lo = mid + 1;
                }
            } else {
                // lower curve
                if(target >= nums[mid] && target <= nums[hi]) {
                    // discard left
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int target1 = 3;
        // ans  4
        System.out.println(searchInSortedAndRotated(nums, target));
        // ans -1
        System.out.println(searchInSortedAndRotated(nums, target1));
    }
}