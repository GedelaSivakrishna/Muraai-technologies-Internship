public class RepeatingElement {
    // Time: O(log n)
    //Space: O(1)
    public static int repeatingElement(int nums[]) {
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] == mid) {
                // discard left
                lo = mid + 1;
            } else {
                if(mid != 0 && nums[mid] == nums[mid - 1]) {
                    return nums[mid];
                }
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {0, 1, 2, 2, 3, 4, 5, 6};
        int nums1[] = {0, 1, 2, 3, 4, 5, 5, 6};
        // ans 2
        System.out.println(repeatingElement(nums));
        // ans 5
        System.out.println(repeatingElement(nums1));
    }
}