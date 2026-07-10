public class SumOfElementsInArray {
    
    public static int f(int nums[], int idx) {
        // base case
        if(idx == nums.length - 1) {
            return nums[idx];
        }
        return nums[idx] + f(nums, idx + 1);
    }
    
    public static void main(String[] args) {
        int nums[] = {1,2,3,4,5};
        System.out.println(f(nums, 0));
    }

}
