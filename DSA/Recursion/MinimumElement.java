public class MinimumElement {

    /*  Time  - O(n)
        Space - O(n)
    */
    public static int minimumElement(int nums[], int min, int i) {
        // base case
        if(i == nums.length) {
            return min;
        }

        // self work
        min = Math.min(nums[i], min);

        return minimumElement(nums, min, i + 1);
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, -5};
        System.out.println(minimumElement(nums, Integer.MAX_VALUE, 0)); // -5
    }
}
