import java.util.Arrays;
public class SubsetsWithSumBetweenAandB {

     public static int upperBound(int nums[], int x) {
        // corner case - may be first element > then x
        if(nums.length > 0 && nums[0] > x) {
            return 0;
        }

        int ans = nums.length;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] <= x) {
                // discard left half
                lo = mid + 1;
            } else {
                ans = mid;
                // search for better answer in left half
                hi = mid - 1;
            }
        }
        return ans;
    }

     public static int lowerBound(int nums[], int x) {
        // corner case - may be first element > then x
        if(nums.length > 0 && nums[0] >= x) {
            return 0;
        }

        int ans = nums.length;
        int lo = 0, hi = nums.length - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(nums[mid] < x) {
                // discard left half
                lo = mid + 1;
            } else {
                ans = mid;
                // search for better answer in left half
                hi = mid - 1;
            }
        }
        return ans;
    }

    public static int[] subsets(int arr[]) {
        int n = arr.length;
        int countOfSubsets = 1 << n; // calculating 2^n
        int subsetSums[] = new int[countOfSubsets];
        int k = 0; // pointer to subsetSums
        for(int num = 0; num < countOfSubsets; num++) {
            int sum = 0;
            for(int i = 0; i < n; i++) {
                if((num & 1 << i) != 0) {
                    sum += arr[i];
                }
            }
            subsetSums[k++] = sum;
        }
        return subsetSums;
    }

    // Time: 2^n/2 * log(2^n/2)
    //Space: O(2^n/2)
    public static int subsetsWithSumBetweenAandB(int nums[], int A, int B) {
        int len = nums.length;
        int left[] = Arrays.copyOfRange(nums, 0, len / 2);
        int right[] = Arrays.copyOfRange(nums, len / 2, len);
        int m[] = subsets(left); // Time: O(2^n/2) -> 2^17
        int n[] = subsets(right); // Time: O(2^n/2) -> 2^17
        Arrays.sort(m); // TIme: ~2^17
        Arrays.sort(n); // TIme: ~2^17
        int count = 0;
        for(int i = 0; i < m.length; i++) { // Time: ~2^17 * log(2^17)
            int lb = lowerBound(n, A - m[i]);
            int ub = upperBound(n, B - m[i]);
            count += ub - lb;
        }
        return count;
    }

    public static void main(String[] args) {
        int nums[] = {1, -2, 3};
        int A = -1, B = 2;        
        System.out.println(subsetsWithSumBetweenAandB(nums, A, B));
    }
}