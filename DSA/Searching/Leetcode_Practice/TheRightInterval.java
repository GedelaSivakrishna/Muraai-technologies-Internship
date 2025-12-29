package Leetcode_Practice;
import java.util.Arrays;
public class TheRightInterval {

    public static int lowerBound(int matrix[][], int target) {
        int n = matrix.length;
        int lo = 0, hi = n - 1;
        int ans = n;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if(matrix[mid][0] >= target) {
                ans = mid;
                // find better answer
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    // Time: O(nlogn)
    //Space: O(n)
    public static int[] theRightInterval(int intervals[][]) {
        int m = intervals.length;
        int n = intervals[0].length;
        int result[] = new int[m];
        int temp[][] = new int[m][2];
        
        // store the interval start & it's index
        for(int i = 0; i < m; i++) {
            temp[i][0] = intervals[i][0];
            temp[i][1] = i;
        }
        
        // sort intervals based on their start
        Arrays.sort(temp, (a, b) -> a[0] - b[0]);

        for(int i = 0; i < m; i++) {
            int lb = lowerBound(temp, intervals[i][1]);
            result[i] = lb == m ? -1 : temp[lb][1];
        }

        return result;
    }

    public static void print(int matrix[][]) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void print(int nums[]) {
        for(int elem : nums) {
            System.out.print(elem + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int intervals[][] = {{3,4}, {2,3}, {1,2}};
        // Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        // ans {-1, 0, 1}
        print(theRightInterval(intervals));
        int intervals2[][] = {{1,4}, {2,3}, {3,4}};
        // ans {-1, 2, -1}
        print(theRightInterval(intervals2));
    }

}