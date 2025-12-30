package Leetcode_Practice;
import java.util.Stack;
public class Pattern132 {

    // Time: O(n^3)
    //Space: O(1)
    public static boolean pattern132Bruteforce(int nums[]) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(nums[i] < nums[k] && nums[k] < nums[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Time: O(n^2)
    //Space: O(1)
    public static boolean pattern132BetterApproach(int nums[]) {
        int n = nums.length;
        int min = nums[0];
        for(int j = 1; j < n; j++) {
            for(int k = j + 1; k < n; k++) {
                if(nums[k] > min && nums[k] < nums[j]) {
                    return true;
                }
            }
            min = Math.min(min, nums[j]);
        }
        return false;
    }

    // Time: O(n)
    //Space: O(n)
    public static boolean pattern132OptimisedApproach(int nums[]) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int thirdElement = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            if(nums[i] < thirdElement) {
                return true;
            }
            while(!stack.isEmpty() && stack.peek() < nums[i]) {
                thirdElement = stack.pop();
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int nums[] = {-1, 3, 2, 0};
        // o/p -> true
        System.out.println(pattern132Bruteforce(nums));
        System.out.println(pattern132BetterApproach(nums));
        System.out.println(pattern132OptimisedApproach(nums));
    }
}