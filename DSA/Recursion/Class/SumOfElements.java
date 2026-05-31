package Class;
public class SumOfElements {

    /*  Time  - O(n)
        Space - O(n)
    */
    public static int f(int nums[], int sum, int i) {
        // base case
        if(i == nums.length) {
            return sum;
        }

        // add element at current index to sum
        sum += nums[i];

        return f(nums, sum, i + 1);
    }
    
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        System.out.println(f(nums, 0, 0));  // 15
    }
}
