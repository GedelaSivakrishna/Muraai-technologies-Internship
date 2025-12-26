package Practice;

public class SearchIn2DMatrix2 {

    public static boolean searchIn2DMatrix2(int matrix[][], int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        // if only 1 element is present
        if(m == 1 && n == 1) {
            return matrix[m][n] == target;
        }

        int row = 0, col = n - 1;
        while(row < m && col >= 0) {
            // if current element equals target
            if(matrix[row][col] == target) return true;

            // current element greater than target, move left
            if(matrix[row][col] > target) {
                col--;
            } else {
                // current element less than target, go to next row
                row++;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int matrix[][] = {{1,4,7,11,15},
                          {2,5,8,12,19},
                          {3,6,9,16,22},
                          {10,13,14,17,24},
                          {18,21,23,26,30}};
        int target1 = 5;
        int target2 = 23;
        // ans -> true
        System.out.println(searchIn2DMatrix2(matrix, target1));
        // ans -> false
        System.out.println(searchIn2DMatrix2(matrix, target2));
    }
}

