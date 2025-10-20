public class SmallerOrEqual {

    public static int upperBound(int nums[], int target) {
        // corner case
        if(nums.length > 0 && nums[0] > target) {
            return nums[0];
        }
        int ans = nums.length;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] <= target) {
                // discard left
                lo = mid + 1;
            } else{
                ans = mid;
                // find better answer in left
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 4, 5, 6, 8, 9};
        int target = 7;
        // ans 5
        System.out.println(upperBound(nums, target));
    }
}
