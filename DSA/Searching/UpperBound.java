public class UpperBound {
    // Time: O(log n)
    //Space: O(1)
    public static int upperBound(int nums[], int x) {
        // corner case - may be first element > then x
        if(nums.length > 0 && nums[0] > x) {
            return 0;
        }

        int ans = nums.length;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] <= x) {
                // discard left half
                lo = mid + 1;
            } else {
                ans = mid;
                // search for better answer in left half
                hi = mid - 1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 2, 2,3, 3, 3, 5, 5, 7};
        int x1 = 3;
        int x2 = 2;
        int x3 = -3;
        int x4 = 10;
        // ans - 6
        System.out.println(upperBound(nums, x1));
        // ans - 3
        System.out.println(upperBound(nums, x2));
        // ans - 0
        System.out.println(upperBound(nums, x3));
        // ans - 9
        System.out.println(upperBound(nums, x4));
    }
}
