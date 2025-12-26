package Practice;

public class PeakElement {

    // Time O(logn)
    //Space O(1)
    public static int peakElement(int nums[]) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // check if mid is peak
            if(mid != 0 && mid != n - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // check if mid is at 0th index
            if(mid == 0 && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // check if mid is at (n-1)th index
            if(mid == n - 1 && nums[mid] > nums[mid - 1]) {
                return mid;
            }
            // increasing curve
            if(mid + 1 < n && nums[mid] < nums[mid + 1]) {
                // move right to find peak
                lo = mid + 1;
            } else {
                // decreasing curve
                // move left to find peak
                hi = mid - 1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int nums[] = {3,2,10,5,4,7,8};
        // ans 0 / 2 / 6
        System.out.println(peakElement(nums));
    }
}
