public class MaxParkedRowIndex {

    public static int maxParkedRowIndex(int matrix[][]) {
        int maxParked = Integer.MIN_VALUE;
        int ans = -1;

        for(int i = 0; i < matrix.length; i++) {
            int currParked = 0;
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1)
                    currParked++;
            }
            if(currParked > maxParked) {
                ans = i;
                maxParked = currParked;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int matrix[][] = {{1,0,0,1},
                          {0,0,0,0},
                          {1,0,0,1}};
        System.out.println(maxParkedRowIndex(matrix)); // 0
    }
}