package Class;
public class MaximumElement {

    /*  Time  - O(n)
        Space - O(n)
    */
    public static int maximumElement(int nums[], int max, int i) {
        // base case
        if(i == nums.length) {
            return max;
        }

        // self work
        max = Math.max(nums[i], max);

        return maximumElement(nums, max, i + 1);
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, -5};
        System.out.println(maximumElement(nums, Integer.MIN_VALUE, 0)); // 4
    }
}
