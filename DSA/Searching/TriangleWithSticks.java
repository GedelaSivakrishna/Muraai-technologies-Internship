import java.util.Arrays;

public class TriangleWithSticks {

    // Time O(log n)
    public static int upperBound(int nums[], int target) {
        int n = nums.length;
        if(n > 0 && nums[0] > target) {
            return 0;
        }

        int lo = 0, hi = n - 1;
        int ans = nums.length;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target) {
                ans = mid;
                // search better answer left
                hi = mid - 1;
            } else {
                // discard left
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static int lowerBound(int nums[], int target) {
        int n = nums.length;
        if(n > 0 && nums[0] >= target) {
            return 0;
        }

        int ans = nums.length;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= target) {
                ans = mid;
                // search better answer
                hi = mid - 1;
            } else {
                // discard left
                lo = mid + 1;
            }
        }
        return ans;
    }

    /* Degenerate Triangles: 
     *      Triangle in which sum of two sides equals third side
     *      i.e     a + b = c
     */

    // Time O(n^2 log n)
    public static int triangleWithSticksExcludeDegenerateTriangles(int nums[]) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                int target = nums[i] + nums[j];
                int ub = upperBound(nums, target);
                ans += (n - ub);
            }
        }
        return ans;
    }

    // Time O(n^2 log n)
    public static int triangleWithSticksIncludeDegenerateTriangles(int nums[]) {
        int n = nums.length;
        int ans = 0;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                int target = nums[i] + nums[j];
                int lb = lowerBound(nums, target);
                ans += (n - lb);
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int nums[] = { 4, 2, 6};
        int nums2[] = {2, 5, 9, 6};
        // ans 0
        System.out.println(triangleWithSticksExcludeDegenerateTriangles(nums));
        // ans 1
        System.out.println(triangleWithSticksIncludeDegenerateTriangles(nums));
        // ans 2
        System.out.println(triangleWithSticksExcludeDegenerateTriangles(nums2));
    }
}
