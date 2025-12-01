import java.util.ArrayList;
public class Subsets {

    public static ArrayList<ArrayList<Integer>> subsets(int nums[]) {
        int n = nums.length;
        int totalSubsets = (int)Math.pow(2, n);
        ArrayList<ArrayList<Integer>> subsets = new ArrayList<>();
        for(int i = 0; i < totalSubsets; i++) {
            ArrayList<Integer> subset = new ArrayList<>();
            for(int j = 0; j < n; j++) { // loop thorough elements whether they will be included / excluded based on bit value
                if ((i & (1 << j)) != 0) { // if bit is 1 -> include, 0 -> exclude
                    subset.add(nums[j]);
                }
            }
            subsets.add(subset);
        }
        return subsets;
    }

    // Time: O(2^n * n)
    //Space: O(n) temporary subset in which all elements are stored, in worst case, all elements are included
    public static int subsetsWithSumBwAAndB(int nums[], int A, int B) {
        int count = 0;
        int n = nums.length;
        int totalSubsets = (int)Math.pow(2, n);
        for(int i = 0; i < totalSubsets; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                if((i & (1 << j)) != 0) {
                    sum += nums[j];
                }
            }
            if(sum >= A && sum <= B) {
                count++;
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int nums[] = { 1, -2, 3 };
        int A = -1, B = 2;
        // System.out.println(subsets(nums));
        System.out.println(subsetsWithSumBwAAndB(nums, A, B));
    }
}
