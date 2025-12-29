package Leetcode_Practice;

public class MinInRotatedSortedArray2 {

    public static int minInRotatedSortedArray2(int nums[]) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[lo] == nums[mid] && nums[mid] == nums[hi]) {
                // check if mid is min element
                min = Math.min(min, nums[mid]);
                lo++;
                hi--;
            } else if (mid - 1 >= 0 && mid + 1 != n && (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1])) {
                min = nums[mid];
                break;
            } else {
                if (nums[mid] >= nums[hi]) {
                    // move right
                    lo = mid + 1;
                } else {
                    // move left
                    hi = mid - 1;
                }
            }
        }
        return min;
    }

    public static int minInRotatedSortedArray(int nums[]) {
        int n = nums.length;
        if(n == 1) {
            return nums[0];
        }
        int min = Integer.MAX_VALUE;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[lo] < nums[hi]) {
                return nums[lo];
            }
            if(mid == n - 1 && mid - 1 >= 0 && nums[mid - 1] > nums[mid]) {
                return nums[mid];
            }
            if(mid - 1 >= 0 && mid + 1 != n && (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1])) {
                return nums[mid];
            }
            if(nums[mid] > nums[hi]) {
                // move right
                lo = mid + 1;
            } else {
                // move left
                hi = mid - 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 5};
        int nums1[] = {4, 5, 6, 7, 0, 1, 4};
        int nums2[] = {2, 2, 2, 0, 1};
        // ans 1
        // System.out.println(minInRotatedSortedArray2(nums));
        // // ans 0
        // System.out.println(minInRotatedSortedArray2(nums1));
        // // ans 0
        // System.out.println(minInRotatedSortedArray2(nums2));
        System.out.println(minInRotatedSortedArray(nums));
    }
}
