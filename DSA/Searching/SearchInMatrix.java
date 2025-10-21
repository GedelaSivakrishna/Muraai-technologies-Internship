public class SearchInMatrix {

    public static boolean searchInMatrix(int matrix[][], int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lo = 0, hi = (m * n) - 1;
        while(lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int row = mid / n;
            int col = mid % n;
            int midElem = matrix[row][col];

            if (midElem == target) {
                return true;
            } else if (midElem < target) {
                // discard left
                lo = mid + 1;
            } else {
                // discard right
                hi = mid - 1;
            }
        }

        return false;
    }
    
    public static void main(String[] args) {
        int matrix[][] = {{1, 3, 5, 7},
                          {10, 11, 16, 20},
                          {23, 30, 34, 60}};
        int target = 34;
        int target2 = 1;
        System.out.println(searchInMatrix(matrix, target));
        System.out.println(searchInMatrix(matrix, target2));
    }
}