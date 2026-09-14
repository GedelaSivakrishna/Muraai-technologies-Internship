public class MinElementInArray {
    
    public static int f(int nums[], int idx) {
        // base case
        if(idx == nums.length - 1) {
            return nums[idx];
        }
        return Math.min(nums[idx], f(nums, idx + 1));
    }
    
    
    public static void main(String[] args) {
        int nums[] = {11,12,33,24,5};
        System.out.println(f(nums, 0));
    }
}
