public class PeakElement {

    // Time O(n)
    //Space O(1)
    public static int peakElementBruteForce(int nums[]) {
        int n = nums.length;
        if(n == 1) {
            return 0;
        }
        for(int i = 0; i < n; i++) {
            if(i == 0 && nums[i] > nums[i + 1]) {
                return i;
            } 
            if (i == n - 1 && nums[i] > nums[i - 1]) {
                return i;
            } 
            if(i != 0 && i != n - 1 && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    // Time O(log n)
    //Space O(1)
    public static int peakElement(int nums[]) {
        int n = nums.length;

        if(n == 1) {
            return 0;
        }

        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            // check if mid element is peak element
            if((mid == 0 && nums[mid] > nums[mid + 1]) || (mid == n - 1 && nums[mid] > nums[mid - 1]) 
              || (mid != 0 && mid != n - 1 && nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1])) {
                return mid;
            }
            // increasing curve
            if(mid != n - 1 && nums[mid] < nums[mid + 1]) {
                // peak element can exist to right
                lo = mid + 1;
            } else {
                // decreasing curve
                // peak element can exist to left
                hi = mid - 1; 
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 1};
        int nums2[] = {1, 2, 1, 3, 5, 6, 4};
        int nums3[] = {1, 2};
        // ans 2
        System.out.println(peakElement(nums));
        // ans 1 / 5
        System.out.println(peakElement(nums2));
    }
}