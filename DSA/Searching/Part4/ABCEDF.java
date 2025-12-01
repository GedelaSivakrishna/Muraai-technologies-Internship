import java.util.Arrays;
public class ABCEDF {

    public static int upperBound(int nums[], int target) {
        int n = nums.length;
        if(n > 0 && nums[0] > target) {
            return 0;
        }

        int lo = 0, hi = n - 1;
        int ans = n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] > target) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    public static int lowerBound(int nums[], int target) {
        int n = nums.length;
        if(n > 0 && nums[0] >= target) {
            return 0;
        }

        int lo = 0, hi = n - 1;
        int ans = n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(nums[mid] >= target) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    // TIme O(n^3 log(n))
    //Space O(n^3)
    public static int abcedf(int nums[]) {
        int n = nums.length;
        int LHS[] = new int[n * n * n];
        int RHS[] = new int[n * n * n];
        int i = 0, j = 0;
        // calculate LHS triplets - O(n^3)
        for(int a = 0; a < n; a++) {
            for(int b = 0; b < n; b++) {
                for(int c = 0; c < n; c++) {
                    LHS[i++] = (nums[a] * nums[b]) + nums[c];
                }
            }
        }

        // calculate RHS triplets - O(n^3)
        for(int d = 0; d < n; d++) {
            for(int e = 0; e < n; e++) {
                for(int f = 0; f < n; f++) {
                    RHS[j++] = nums[d] * (nums[e] + nums[f]);
                }
            }
        }

        // sort RHS - O(n^3 log(n^3))
        Arrays.sort(RHS);

        int count = 0;
        // O(n^3 log(n^3))
        for(int k = 0; k < LHS.length; k++) {
            int lb = lowerBound(RHS, LHS[k]);
            int ub = upperBound(RHS, LHS[k]);
            count += ub - lb;
        }

        return count;
    }
    
    public static void main(String[] args) {
        int nums[] = {2, 3};
        // ans 4
        System.out.println(abcedf(nums));
        int nums2[] = {1};
        // ans 1
        System.out.println(abcedf(nums2));
        int nums3[] = {1, -1};
        // ans 24
        System.out.println(abcedf(nums3));
        int nums4[] = {5, 7, 10};
        // ans 10
        System.out.println(abcedf(nums4));
    }
}
