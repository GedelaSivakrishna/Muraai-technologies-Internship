public class FirstGreaterOrEqual {
    // time: O(log n)
    //space: O(1)
    public static int firstGreaterOrEqual(int nums[], int x) {
        // corner case - may be first element is answer
        if(nums.length > 0 && nums[0] >= x) {
            return 0;
        } 
        int ans = -1;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] >= x) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 2, 3, 3, 3, 5, 5};
        int x1 = 3;
        int x2 = 4;
        int x3 = 5;

        // ans - 3
        System.out.println(firstGreaterOrEqual(nums, x1));
        // ans - 6
        System.out.println(firstGreaterOrEqual(nums, x2));
        // ans - 6
        System.out.println(firstGreaterOrEqual(nums, x3));
    }
}
