import java.util.Arrays;
import java.util.HashMap;
public class NonRepeatingNumber {

    /* We are given an array of integers in which every element occurs twice except one.
       Find the non repeating element.
    */

    /*  Time  - O(n logn) 
        Space - O(1) 
    */
    public static int nonRepeatingNumberSortingApproach(int nums[]) {
        Arrays.sort(nums);

        int ans = -1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i - 1] != nums[i]) {
                ans = nums[i - 1];
                break;
            }
        }

        return ans;
    }

    /*  Time  - O(n) 
        Space - O(n) 
    */
    public static int nonRepeatingNumberMapApproach(int nums[]) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int elem : nums)
            map.put(elem, map.getOrDefault(elem, 0) + 1);

        int ans = -1;
        for(int key : map.keySet()) {
            if(map.get(key) == 1) {
                ans = key;
                break;
            }
        }

        return ans;
    }

    /*  Time  - O(n) 
        Space - O(1) 
    */
    public static int nonRepeatingNumber(int nums[]) {
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            ans = ans ^ nums[i];
        }

        return ans;
    }
    
    public static void main(String[] args) {
        int nums[] = {2, 2, 1};
        System.out.println(nonRepeatingNumber(nums)); // 1
        System.out.println(nonRepeatingNumberMapApproach(nums)); // 1
        System.out.println(nonRepeatingNumberSortingApproach(nums)); // 1
    }
}
