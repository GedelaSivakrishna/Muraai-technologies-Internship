package Class;
public class LinearSearch {

    /*  Time  - O(n)
        Space - O(n)
    */
    public static boolean f(int nums[], int target, int i) {
        // base case
        if(i == nums.length) {
            return false;
        }

        // self work
        if(nums[i] == target) {
            return true;
        }

        return f(nums, target, i + 1);
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        System.out.println(f(nums, 10, 0)); // false
        System.out.println(f(nums, 0, 0)); // false
        System.out.println(f(nums, 1, 0)); // true
    }
}
