public class SmallestNonNegative {

    public static int smallestNonNegative(int nums[]) {
        // corner case - may be first element is answer
        if(nums.length > 0 && nums[0] != 0) {
            return 0;
        }
        int ans = nums.length;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] == mid) {
                lo = mid + 1;
            } else {
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums1[] = {0, 1, 2, 6, 9, 11, 15};
        int nums2[] = {1, 2, 3, 4, 6, 9, 11, 15};
        int nums3[] = {0, 1, 2, 3, 4, 5, 6};
        // ans - 3
        System.out.println(smallestNonNegative(nums1));
        // ans - 0
        System.out.println(smallestNonNegative(nums2));
        // ans - 7
        System.out.println(smallestNonNegative(nums3));
    }
}
