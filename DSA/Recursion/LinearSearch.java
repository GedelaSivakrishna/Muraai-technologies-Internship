public class LinearSearch {

    // Time: O(n)
    //Space: O(n)
    public static int f(int nums[], int idx, int target) {
        // base case
        if(idx == nums.length) return -1;

        // self work
        if(nums[idx] == target) return idx;

        // assumption
        return f(nums, idx + 1, target);
    }
    
    public static void main(String[] args) {
        int nums[] = {2, 1, -3, 5, 7, 3};
        System.out.println(f(nums, 0, 11));
    }
}
