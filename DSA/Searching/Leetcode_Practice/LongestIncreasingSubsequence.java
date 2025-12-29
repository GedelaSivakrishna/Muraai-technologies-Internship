package Leetcode_Practice;
import java.util.ArrayList;
public class LongestIncreasingSubsequence {

    public static int lowerBound(ArrayList<Integer> nums, int target) {
        int n = nums.size();
        if(n == 1 && nums.get(0) >= target) {
            return 0;
        }
        int lo = 0, hi = n - 1;
        int ans = n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums.get(mid) >= target) {
                ans = mid;
                // find better answer to left
                hi = mid - 1;
            } else {
                // discard left
                lo = mid + 1;
            }
        }
        return ans;
    } 

    public static int longestIncreasingSubsequence(int nums[]) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < n; i++) {
            int currElem = nums[i];
            if(currElem > list.getLast()) {
                list.add(currElem);
            } else {
                int lb = lowerBound(list, currElem);
                list.set(lb, currElem);
            }
        }
        return list.size();
    }
    
    public static void main(String[] args) {
        int nums[] = {10, 9, 2, 5, 3, 7, 101, 18};
        int nums2[] = {0, 1, 0, 3, 2, 3};
        int nums3[] = {7, 7, 7, 7, 7, 7, 7};
        // ans 4
        System.out.println(longestIncreasingSubsequence(nums));
        // ans 4
        System.out.println(longestIncreasingSubsequence(nums2));
        // ans 1
        System.out.println(longestIncreasingSubsequence(nums3));
    }
}
