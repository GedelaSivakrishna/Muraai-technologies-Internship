import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
public class IntersectionOfArrays {

    // Time O(n)
    //Space O(n)
    public static int[] intersectionOfArrays(int nums1[], int nums2[]) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans  = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++) {
            int element = nums1[i];
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        for(int i = 0; i < nums2.length; i++) {
            int element = nums2[i];
            if(map.containsKey(element) && map.get(element) > 0) {
                ans.add(element);
                map.put(element, map.get(element) - 1);
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

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

    public static int lowerBound(int nums[], int target) {
        int n = nums.length;
        if(n > 0 && nums[0] >= target) {
            return 0;
        }

        int ans = n;
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

    // Time O(n logn)
    //Space O(1)
    public static int[] intersectionOfArrays2(int nums1[], int nums2[]) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0; i < nums1.length; ) {
            int target = nums1[i];
            int lb1 = lowerBound(nums1, target);
            int ub1 = upperBound(nums1, target);
            int lb2 = lowerBound(nums2, target);
            int ub2 = upperBound(nums2, target);
            int minOccur = Math.min((ub1 - lb1), (ub2 - lb2));
            while(minOccur-- > 0) {
                ans.add(target);
            }
            i = ub1;
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    
    public static void main(String[] args) {
        int nums1[] = {1, 2, 2, 1};
        int nums2[] = {2, 2};
        int nums3[] = {4, 9, 5};
        int nums4[] = {9, 4, 9, 8, 4};
        // ans 2 2
        // int ans[] = intersectionOfArrays(nums1, nums2);
        // ans 4 9
        int ans[] = intersectionOfArrays2(nums3, nums4);
        for(int elem : ans) {
            System.out.print(elem +" ");
        }
    }
}
