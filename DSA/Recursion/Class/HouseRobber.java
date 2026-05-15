package Class;
public class HouseRobber {

    /*  Time  - O(n^3)
        Space - O(1)
    */
    public static int houseRobberLoopApproach(int nums[]) {
        int n = nums.length;
        int maxAmount = Integer.MIN_VALUE;

        for(int i = 0; i < n; i++) {
            for(int j = i + 2; j < n; j++) {
                int currAmount = nums[i] + nums[j];
                for(int k = j + 2; k < n; k += 2) {
                    currAmount += nums[k];
                }
                maxAmount = Math.max(currAmount, maxAmount);
            }
        }

        return maxAmount;
    }

    /*  Time  - O(2^n) -> total recursive calls * work done in each call
        Space - O(n) -> the maximum depth of recursive tree
    */
    public static int f(int arr[], int idx) {
        // base case
        if(idx >= arr.length) { // no house, no money to rob
            return 0;
        }

        return Math.max(arr[idx] + f(arr, idx + 2), 0 + f(arr, idx + 1));
    }
    
    public static void main(String[] args) {
        int houses[] = {3, 1, 1, 9};
        // System.out.println(houseRobberLoopApproach(houses));    // 19
    }
}
