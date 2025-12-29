package Leetcode_Practice;
import java.util.Arrays;
import java.util.ArrayList;

public class IntersectionOfArrays {

    public static int upperBound(int nums[], int target) {
        int n = nums.length;
        if(n > 0 && nums[0] > target) {
            return 0;
        }

        int lo = 0, hi = n - 1;
        int ans = n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target) {
                // found pottential answer
                ans = mid;
                // search better answer i.e 1st greater than target value
                // move left
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

        int lo = 0, hi = n - 1;
        int ans = n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= target) {
                // found pottential answer
                ans = mid;
                // search better answer to left
                hi = mid - 1;
            } else {
                // discard left
                lo = mid + 1;
            }
        }
        return ans;
    }

    // Time O(nlogn + mlogm + n(logn + logm))
    //Space O(1)
    public static int[] intersectionOfArrays(int nums1[], int nums2[]) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; ) {
            int currElement = nums1[i];
            int lb1 = lowerBound(nums1, currElement);
            int ub1 = upperBound(nums1, currElement);
            int lb2 = lowerBound(nums2, currElement);
            int ub2 = upperBound(nums2, currElement);
            int commonOccurrence = Math.min((ub1 - lb1), (ub2 - lb2));
            while(commonOccurrence-- > 0) {
                list.add(currElement);
            }
            i = ub1;
        }
        int ans[] = new int[list.size()];
        int index = 0;
        for(int elem : list) {
            ans[index++] = elem;
        }
        return ans;
    }

    public static int[] intersectionOfArraysUnique(int nums1[], int nums2[]) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums1.length; ) {
            int currElement = nums1[i];
            int lb1 = lowerBound(nums1, currElement);
            int ub1 = upperBound(nums1, currElement);
            int lb2 = lowerBound(nums2, currElement);
            int ub2 = upperBound(nums2, currElement);
            int commonOccurrence = Math.min((ub1 - lb1), (ub2 - lb2));
            if(commonOccurrence > 0) {
                list.add(currElement);
            }
            i = ub1;
        }
        int ans[] = new int[list.size()];
        int index = 0;
        for(int elem : list) {
            ans[index++] = elem;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int nums1[] = {4,2,5,6,3,1,2,3,4};
        int nums2[] = {1,4,2,7,6,8,2};
        int ans[] = intersectionOfArrays(nums1, nums2);
        int ans2[] = intersectionOfArraysUnique(nums1, nums2);
        // ans {1,2,2,4,6}
        // for(int elem : ans) {
        //     System.out.print(elem + " ");
        // }
        // ans {1,2,4,6}
        for(int elem : ans2) {
            System.out.print(elem + " ");
        }
    }
}
