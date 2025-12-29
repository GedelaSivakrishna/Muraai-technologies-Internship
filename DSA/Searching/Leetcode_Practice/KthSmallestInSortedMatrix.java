package Leetcode_Practice;

public class KthSmallestInSortedMatrix {

    // Time: O(n)
    public static int countSmallerEqual(int matrix[][], int target) {
        int n = matrix.length;
        int count = 0;
        int row = 0, col = n - 1;

        while(row < n && col >= 0) {
            if(matrix[row][col] <= target) {
                count += col + 1;
                row++;
            } else {
                col--;
            }
        }
        return count;
    }

    // Time: O(n * log(max - min))
    //Space: O(1)
    public static int kthSmallestInSortedMatrix(int matrix[][], int k) {
        int n = matrix.length;
        int lo = matrix[0][0];
        int hi = matrix[n - 1][n - 1];
        int ans = 0;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if(countSmallerEqual(matrix, mid) < k) {
                // move right, as there are less elements than k
                lo = mid + 1;
            } else {
                ans = mid;
                // find better answer
                hi = mid - 1;
            }
        }
        return ans;
    }
    

    public static void main(String[] args) {
        int[][] matrix = 
                        {{10, 20, 30, 40},
                        {15, 25, 35, 45},
                        {24, 29, 37, 48},
                        {32, 33, 39, 50}};
        // ans 20
        System.out.println(kthSmallestInSortedMatrix(matrix, 4));
    }
}
