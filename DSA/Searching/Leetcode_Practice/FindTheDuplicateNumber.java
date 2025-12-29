package Leetcode_Practice;
import java.util.Arrays;
import java.util.HashSet;
public class FindTheDuplicateNumber {

    // Time: O(n^2)
    //Space: O(1)
    public static int bruteForce(int nums[]) {
        int n = nums.length;
        int ans = -1;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == nums[j]) {
                    ans = nums[i];
                    break;
                }
            }
        }
        return ans;
    }

    // Time: O(nlogn)
    //Space: O(1)
    public static int sortingApproach(int nums[]) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = -1;
        for(int i = 0; i < n - 1; i++) {
            if(nums[i] == nums[i + 1]) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    // Time: O(n)
    //Space: O(n)
    public static int hashSetApproach(int nums[]) {
        HashSet<Integer> set = new HashSet<>();
        int n = nums.length;
        int ans = -1;
        for(int i = 0; i < n; i++) {
            if(set.contains(nums[i])) {
                ans = nums[i];
                break;
            } else {
                set.add(nums[i]);
            }
        }
        return ans;
    }

    // Time: O(n)
    //Space: O(1)
    public static int slowFastPointerApproach(int nums[]) {
        int slow = nums[0];
        int fast = nums[0];

        // loop till, slow & fast meet
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0]; // reset fast pointer
        // now the first time they meet, slow will be at duplicate number
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 3, 4, 2, 2};
        int nums2[] = {1, 1, 2};
        int nums3[] = {3, 3, 3, 3, 3};
        // ans - 2
        System.out.println(slowFastPointerApproach(nums));
        // ans - 1
        System.out.println(slowFastPointerApproach(nums2));
        // ans - 3
        System.out.println(slowFastPointerApproach(nums3));
    }

}
