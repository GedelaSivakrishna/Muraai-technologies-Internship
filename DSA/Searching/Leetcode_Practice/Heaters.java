package Leetcode_Practice;
import java.util.Arrays;
public class Heaters {

    public static int upperBound(int nums[], int target) {
        int n = nums.length;
        if(n > 0 && nums[0] > target) {
            return 0;
        }

        int ans = n;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target) {
                ans = mid;
                // find better answer
                hi = mid - 1;
            } else {
                // discard left
                lo = mid + 1;
            }
        }
        return ans;
    }

    // Time: O(max(mlogm, nlogm))
    // mlogm - sorting heaters, nlogm - traversing houses and uppeBound on heaters
    // Space: O(1)
    public static int minRadiusOfHeaters(int houses[], int heaters[]) {
        // sort the heaters positions
        Arrays.sort(heaters);
        int m = heaters.length;
        int minRadius = Integer.MIN_VALUE;
        for(int i = 0; i < houses.length; i++) {
            int ub = upperBound(heaters, houses[i]);
            int radius;
            if(ub == 0) {
                radius = Math.abs(heaters[ub] - houses[i]);
            } else if(ub == m) {
                radius = Math.abs(heaters[m - 1] - houses[i]);
            } else {
                radius = Math.min(Math.abs(heaters[ub - 1] - houses[i]), Math.abs(heaters[ub] - houses[i]));
            }
            minRadius = Math.max(minRadius, radius);
        }
        return minRadius;
    }
    
    public static void main(String[] args) {
        int houses[] = {3, 9, 2, 4, 11};
        int heaters[] = {1, 8, 5};
        // o/p -> 3
        // System.out.println(minRadiusOfHeaters(houses, heaters));
        int houses2[] = {1, 5};
        int heaters2[] = {10};
        // o/p -> 3
        System.out.println(minRadiusOfHeaters(houses2, heaters2));
        int houses3[] = {1, 2, 3, 4};
        int heaters3[] = {1, 4};
        // o/p -> 1
        // System.out.println(minRadiusOfHeaters(houses3, heaters3));
    }
}
