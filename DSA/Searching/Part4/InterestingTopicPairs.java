import java.util.Arrays;
public class InterestingTopicPairs {

    public static int upperBound(int nums[], int target, int si) {
        int n = nums.length;
        int ans = n;
        int lo = si, hi = n - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(target > -nums[mid]) {
                ans = mid;
                // find better answer
                hi = mid - 1;
            }
            else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    // Time O(nlogn)
    //Space O(n)
    public static int interestingTopicPairs(int a[], int b[]) {
        int n = a.length;
        int c[] = new int[n];
        //store a[i] - b[i] in c
        for(int i = 0; i < n; i++) {
            c[i] = a[i] - b[i];
        }
        Arrays.sort(c);

        int count = 0;
        for(int i = 0; i < n; i++) {
            int ub = upperBound(c, c[i], i + 1);
            count += n - ub;
        }
        return count;
    }
    public static void main(String[] args) {
        int a[] = {4, 8, 2, 6, 2};
        int b[] = {4, 5, 4, 1, 3};
        // ans 7
        // System.out.println(interestingTopicPairs(a, b));
        int a1[] = {1,3,2,4};
        int b1[] = {1,3,2,4};
        // ans 0
        System.out.println(interestingTopicPairs(a1, b1));

    }
}